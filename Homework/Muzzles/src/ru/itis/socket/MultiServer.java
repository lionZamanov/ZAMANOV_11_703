package ru.itis.socket;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import ru.itis.game.Engine;
import ru.itis.game.Muzzle;

import java.util.Timer;
import java.util.TimerTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiServer {
    // список клиентов
    private List<ClientHandler> clients;
    private int id;
    private ClientHandler currentTurnClient;
    private ClientHandler enemyClient;
    private double windResist;
    private boolean locked;

    public MultiServer() {
        // Список для работы с многопоточностью
        currentTurnClient = null;
        locked = true;
        clients = new CopyOnWriteArrayList<>();
    }

    public void start(int port) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // запускаем бесконечный цикл
        while (true) {
            try {
                // запускаем обработчик сообщений для каждого подключаемого клиента
                ClientHandler clientHandler = new ClientHandler(serverSocket.accept(), id);
                clientHandler.start();
                id++;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private class ClientHandler extends Thread {
        // связь с одним клиентом
        private Muzzle muzzle;
        private Socket clientSocket;
        private BufferedReader in;
        private int clientId;

        public int getClientId() {
            return clientId;
        }

        public Muzzle getMuzzle() {
            return muzzle;
        }

        ClientHandler(Socket socket, int clientId) {
            this.clientId = clientId;
            this.clientSocket = socket;
            clients.add(this);
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("id -1 setId " + clientId);
                if (clientId == 0) {
                    muzzle = new Muzzle(1);
                    currentTurnClient = this;
                } else {
                    muzzle = new Muzzle(-1);
                    enemyClient = this;
                    locked = false;
                    notifyUsersConfig();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("New client");
        }

        public void run() {
            try {
                // получем входной поток для конкретного клиента
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (".".equals(inputLine)) {
                        for (ClientHandler client : clients) {
                            PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                            out.println("bye");
                        }
                        break;
                    } else {
                        System.out.println(inputLine);
                        String response[] = inputLine.split(" ");
                        if (response[2].equals("rotate")) {
                            notifyUsersAboutRotating(response);
                        } else if (response[2].equals("shootParams")) {
                            if(!locked) {
                                notifyUsersAboutShoot(response);
                            }
                        }
                    }
                }
                in.close();
                clientSocket.close();
            } catch (
                    Exception e) {
                throw new IllegalStateException(e);
            }
        }

        private void notifyUsersAboutRotating(String[] response) {
            for (ClientHandler client : clients) {
                PrintWriter out = null;
                try {
                    out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                    String clientId = Integer.toString(client.getClientId());
                    if (!response[1].equals(clientId)) {
                        out.println(String.join(" ", response));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void notifyUsersAboutShoot(String[] response) {
            Timer timer = new Timer();
            double speed = Double.valueOf(response[3]);
            double angle = Double.valueOf(response[4]);
            final double[] t = {0};
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Engine engine = new Engine();
                    t[0] += 0.07;
                    double[] coordinates = engine.getCoordinatesByVector(speed, windResist, 1, angle, t[0]);
                    if (coordinates[1] > 100 || t[0] > 15 || isHit(coordinates[0], coordinates[1])) {
                        if(isHit(coordinates[0], coordinates[1])) {
                            enemyClient.getMuzzle().subtractHp(20);
                            if(enemyClient.getMuzzle().isDead()){
                                gameOver();
                            }else{
                                t[0] = 0;
                                this.cancel();
                                changeTurn();
                            }
                        }else {
                            t[0] = 0;
                            this.cancel();
                            changeTurn();
                        }
                    } else {
                        for (ClientHandler client : clients) {
                            PrintWriter out = null;
                            try {
                                out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.println("id " + currentTurnClient.getClientId() + " whizzbangCoordinates " + coordinates[0] + " " + coordinates[1]);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }, 10, 10);
        }
        private boolean isHit(double x, double y){
            return Math.abs(x - 1350 * currentTurnClient.getMuzzle().getDirection()) + Math.abs(y) < 100;
        }

        private void gameOver(){
            locked = true;
            notifyUsersAboutEndTheGame();
        }

        private void notifyUsersAboutEndTheGame(){
            for (ClientHandler client : clients) {
                PrintWriter out = null;
                try {
                    out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                    out.println("id -1 endGame " + currentTurnClient.getClientId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        private void changeTurn() {
            ClientHandler change = currentTurnClient;
            currentTurnClient = enemyClient;
            enemyClient = change;
            notifyUsersConfig();
        }

        private void notifyUsersConfig() {
            windResist = Math.random();
            for (ClientHandler client : clients) {
                PrintWriter out = null;
                try {
                    out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                    out.println("id " + enemyClient.getClientId() + " whizzbangCoordinates " + 0 + " " + 0);
                    out.println("id " + enemyClient.getClientId() + " invisible " + 0);
                    out.println("id " + currentTurnClient.getClientId() + " hp " + currentTurnClient.getMuzzle().getHp());
                    out.println("id " + enemyClient.getClientId() + " hp " + enemyClient.getMuzzle().getHp());
                    out.println("id " + currentTurnClient.getClientId() + " turn");
                    out.println("id -1 windResist " + String.format("%.2f", windResist));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
