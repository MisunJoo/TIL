package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handler extends Thread{
    private String methodName;
    private String pathName;
    private Map<String, String> headerInfo = new HashMap<>();
    private Socket socket;
    private String first;



    public Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("+++++++++");
        BufferedReader in = null;
        PrintWriter out = null;

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));


            this.first = in.readLine();
            String[] firstLine = this.first.split(" / ");
            methodName = firstLine[0];
            pathName = firstLine[1];

            System.out.println("result : " + methodName + ","+ pathName);

            String line;

            while(true){

                line = in.readLine();

                if(line.equals(""))
                    break;

                System.out.println(line);
                String[] list = line.split(":");
                //System.out.println(list[0] + "," + list[1]);

                headerInfo.put(list[0], list[1]);
                System.out.println("result는" + list[0] + headerInfo.get(list[0]));
            }

            System.out.println("---------------");

        }
        catch(Exception e) {
            e.printStackTrace();
        }finally {
            try{ in.close(); }catch(Exception e){}
            try{ out.close(); }catch(Exception e){}
        }
    }
}

