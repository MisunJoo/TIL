package my.examples.was;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private int port;

    public Server(int port){
        this.port = port;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while(true) {
                Socket socket = serverSocket.accept(); //블러킹메소드. 클라이언트에서 기다림
                Handler handler = new Handler(socket);
                handler.start();
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try{
                serverSocket.close();
            }catch (IOException ex){}
        }

    }
}
