//package my.examples.chat;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//
//public class SocketHandler extends Thread{
//    private ChatServer chatServer;
//    private Socket socket;
//
//    public SocketHandler(ChatServer chatServer, Socket socket){
//        this.chatServer = chatServer;
//        this.socket = socket;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("SocketHandler Start");
//        //socekt이 끊어짐녀 exception 발생
//        InputStream in = null;
//        OutputStream out = null;
//
//        try {
//            in = socket.getInputStream();
//            out = socket.getOutputStream();
//        }catch(Exception ex){
//            try{
//                in.close();;
//            }catch (Exception e){}
//
//            try{
//                out.close();
//            }catch (Exception e){}
//
//            //해당 socket이 끊어졌다는 것을 챗서버에게 알려야한다.
//        }
//
//        System.out.println(socket);
//    }
//}


package my.examples.chat;

import java.io.*;
import java.net.Socket;

public class SocketHandler extends Thread{
    private ChatServer chatServer;
    private Socket socket;
    private String name;

    public SocketHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("SocketHandler Start");
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.name = in.readLine(); //첫 줄은 이름
            chatServer.broadcast(this.name + "님이 입장하셨습니다.");

            chatServer.addPrintWriter(out); //직므 접속한 사용자의 out추가


            String line = null;
            while((line = in.readLine()) != null){ // 네트워 연결이 끊어질때지 null이 나오면 끝.
//                out.println(line);
//                out.flush();
                chatServer.broadcast(this.name +" : " + line);
            }
        }catch(Exception ex){
            System.out.println("Chat Handler close");
        }finally {
            chatServer.addPrintWriter(out); //해당되는걸 remove 해야함
            System.out.println("Chat Handler finally");
            try{ in.close(); }catch(Exception e){}
            try{ out.close(); }catch(Exception e){}
        }
    }
}