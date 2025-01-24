package Server;

import java.net.Socket;
import java.io.*;

public class ConnectServer extends Thread{
    private Socket socket;
    private int balance = 10000;

    public ConnectServer(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
          while (true){
              DataInputStream inputStream = new DataInputStream(socket.getInputStream());
              DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

              String msg = inputStream.readLine();

              switch (msg){
                  case "balance":
                      outputStream.writeChars("Balance:" + balance + "UAN");
                      break;
                  case "exit": inputStream.close();
                               outputStream.close();
                               socket.close();
                               System.out.println("Disconnect");
                  default: outputStream.writeChars("Command not found!");
              }
          }
       }catch (Exception e){}
    }
}
