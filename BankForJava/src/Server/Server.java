package Server;

import java.net.*;

public class Server {
    private int port;

    public Server(int port){
        this.port = port;
    }
    public void start(){
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            while (true){
                System.out.println("Listen...");
                new ConnectServer(serverSocket.accept()).start();
                System.out.println("Connect!");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
    }
}
