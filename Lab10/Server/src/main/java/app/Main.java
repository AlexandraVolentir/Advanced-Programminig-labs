package app;

import server.Server;

public class Main {
    public static void compulsory(){
        Server server = new Server();
        server.startServer();
    }

    public static void main(String[] args) {
        compulsory();
    }
}
