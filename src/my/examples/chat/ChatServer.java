package my.examples.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


public class ChatServer extends Thread {

    private  int port; //서버는 포트를 가져야함.
    private Set<PrintWriter> socketSet = null; //같은 객체가 아니니, key값으로 삭제. clinetOutputSet

    public ChatServer(int port){
        this.port = port;
        this.socketSet = new CopyOnWriteArraySet<>();
    }

    public void addPrintWriter(PrintWriter out){
        socketSet.add(out);
    }

    public void removePrintWriter(PrintWriter out){
        socketSet.remove(out);
    }

    public void broadcast(String msg){
        for(PrintWriter out : socketSet){
            try {
                out.println(msg);
                out.flush();
            }catch(Exception ex){} //네트워크에서 문제가 생긴애만 에러처리 아무일안해줌.
        }
    }


    //serversocket도 반드시 close해준다.
    @Override
    public void run() {
        //채팅서버가 해야할 작업을 코딩

        ServerSocket serverSocket = null; //try catch 하기 위해 null로 해준다.
        try {
            serverSocket = new ServerSocket(port); //serversocket은 port를 기다림

            while(true) {
                Socket socket = serverSocket.accept(); //블러킹메소드. 클라이언트에서 기다림
                SocketHandler handler = new SocketHandler(this, socket);
                handler.start();
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            }catch (Exception ex){}
        }
    }
}
