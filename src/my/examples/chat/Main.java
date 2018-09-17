package my.examples.chat;

public class Main {
    public static void main(String[] args){
        ChatServer chatServer = new ChatServer(11000);
        chatServer.start(); //스레드이니
    }
}
