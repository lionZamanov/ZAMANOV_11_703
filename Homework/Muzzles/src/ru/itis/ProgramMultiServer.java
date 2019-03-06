package ru.itis;

import ru.itis.socket.MultiServer;

public class ProgramMultiServer {
    public static void main(String[] args) {
        MultiServer server = new MultiServer();
        server.start(6666);
    }
}
