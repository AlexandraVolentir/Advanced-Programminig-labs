package app;

import java.io.*;
import java.net.*;
import java.util.*;

class Client {
    private static final int PORT = 2222;
    /**
     * connect to the server using the localhost
     * and the port number, then perform write/read from server
     */
    public static void establishConnection(){
        try (Socket socketDescriptor = new Socket("localhost", PORT)) {
            PrintWriter writer = new PrintWriter(socketDescriptor.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketDescriptor.getInputStream()));
            Scanner sc = new Scanner(System.in);
            String line = null;
            while (!"exit".equalsIgnoreCase(line)) {
                line = sc.nextLine();
                writer.println(line);
                writer.flush();
                System.out.println("$[server]: " + reader.readLine());
                if(line.startsWith("stop")){
                    sc.close();
                    System.exit(0);
                }
            }
            sc.close();
        }
        catch (IOException e) {
            System.out.println("client stopped its execution");
        }
    }
    public static void compulsory(){
        establishConnection();
    }
    public static void main(String[] args) {
        compulsory();
    }
}