package ru.itis.socket;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import ru.itis.game.Engine;
import ru.itis.game.Muzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiServer {
    // список клиентов
    private List<ClientHandler> clients;
    private int id;
    private ClientHandler currentTurnClient;
    private ClientHandler enemyClient;
    private double windResist;

    public MultiServer() {
        // Список для работы с многопоточностью
        id = 0;
        currentTurnClient = null;
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
                ClientHandler clientHandler = new ClientHandler(serverSocket.accept());
                clientHandler.setClientId(id);
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

        public void setClientId(int id) {
            this.clientId = id;
        }

        ClientHandler(Socket socket) {
            this.clientSocket = socket;
            // добавляем текущее подключение в список
            clients.add(this);
            PrintWriter out = null;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("setId " + clientId);
                out.println("id " + clientId + " hp " + 100);
                if (clientId == 0) {
                    muzzle = new Muzzle(1);
                    currentTurnClient = this;
                } else {
                    muzzle = new Muzzle(-1);
                    enemyClient = this;
                    out.println("id " + 0 + " turn");
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
                        // бегаем по всем клиентам и обовещаем их о событии
                        for (ClientHandler client : clients) {
                            PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                            out.println("bye");
                        }
                        break;
                    } else {
                        String response[] = inputLine.split(" ");
                        for (ClientHandler client : clients) {
                            PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                            if (response[1].equals("rotate")) {
                                String clientId = Long.toString(client.getClientId());
                                if (!response[0].equals(clientId)) {
                                    out.println(String.join(" ", response));
                                }
                            } else if (response[1].equals("shootParams")) {
                                double speed = Double.valueOf(response[2]);
                                double angle = Double.valueOf(response[3]);
                                final double[] t = {0};
                                Engine engine = new Engine();
                                Timeline timeline = new Timeline();
                                timeline.setCycleCount(Timeline.INDEFINITE);
                                timeline.getKeyFrames().add(new KeyFrame(
                                        new Duration(10),
                                        s -> {
                                            t[0] += 0.07;
                                            double[] coordinates = engine.getCoordinatesByVector(speed, windResist, 1, angle, t[0]);
                                            if (Math.abs(coordinates[0] - 1350 * currentTurnClient.getMuzzle().getDirection()) + Math.abs(coordinates[1]) < 100) {
                                                enemyClient.getMuzzle().subtractHp(20);
                                                t[0] = 0;
                                                timeline.stop();
                                                changeTurn();
                                            } else if (coordinates[1] > 100) {
                                                t[0] = 0;
                                                timeline.stop();
                                                changeTurn();
                                            } else if (t[0] > 15) {
                                                t[0] = 0;
                                                timeline.stop();
                                                changeTurn();
                                            } else {
                                                out.println("id " + currentTurnClient.getClientId() + " whizzbangCoordinates " + coordinates[0] + " " + coordinates[1]);
                                                //currentTurnClient.getMuzzle().getWhizzbang().getTransforms().add(new Rotate(3 * currentMuzzle.getDirection(), 20, 20));
                                            }

                                        }
                                ));
                                timeline.play();
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

        private void changeTurn() {
            for (ClientHandler client : clients) {
                PrintWriter out = null;
                windResist = Math.random();
                try {
                    out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                    out.println("id " + currentTurnClient.getClientId() + " whizzbangCoordinates " + 0 + " " + 0);
                    out.println("id " + currentTurnClient.getClientId() + " invisible " + 0);
                    out.println("id " + currentTurnClient.getClientId() + " hp " + currentTurnClient.getMuzzle().getHp());
                    out.println("id " + enemyClient.getClientId() + " hp " + currentTurnClient.getMuzzle().getHp());
                    out.println("id " + enemyClient.getClientId() + " turn");
                    out.println("windResist " + String.format("%.2f", windResist));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ClientHandler change = currentTurnClient;
                currentTurnClient = enemyClient;
                enemyClient = change;
            }
        }
    }
}
