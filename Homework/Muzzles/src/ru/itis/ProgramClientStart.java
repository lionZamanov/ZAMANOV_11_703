package ru.itis;

import ru.itis.socket.SocketClient;
import java.util.Scanner;

/**
 * 12.02.2019
 * ProgramClientStart
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ProgramClientStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocketClient client = new SocketClient();
        client.startConnection("127.0.0.1", 6666);
        while (true) {
            String message = scanner.nextLine();
            client.sendMessage(message);
        }
    }
}
