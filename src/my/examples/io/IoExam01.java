package my.examples.io;


import java.io.*;

//1 바이트씩 읽어서 1 바이트씩 쓰기
public class IoExam01 {
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;

        try {
            File file = new File("/Users/misun/Documents/Java/TIL/README.md");

            if(!file.isDirectory() && file.exists()) {

                in = new FileInputStream(file);
                out = new FileOutputStream("/tmp/readme.out");

                int readData = 0;
                while ((readData = in.read()) != -1) {
                    out.write(readData);
                }
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try {
                in.close();
            }catch (IOException ioe){}
            try{
                out.close();
            }catch (IOException ioe){}
        }

        int readCount = 0;


    }
}
