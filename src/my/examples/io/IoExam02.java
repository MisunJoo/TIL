package my.examples.io;

import java.io.*;

//[]로 읽어서 []로 쓴다.
public class IoExam02 {
    public static void main(String[] args){
        InputStream in = null;
        OutputStream out = null;

        File file = new File("/Users/misun/Documents/Java/TIL/README.md");

        try {
            in = new FileInputStream(file);
            out = new FileOutputStream("/tmp/readme.out");

            byte[] buffer = new byte[1024];
            int readCount = 0;

            while( (readCount = in.read(buffer)) != -1){
                out.write(buffer,0, readCount);
                System.out.println(readCount);
            }



        }catch (IOException ex){
            ex.printStackTrace();
        }
        finally {
            try{
                in.close();
            }
            catch (IOException ioe){}
            try{
                out.close();
            }
            catch (IOException ioe){}

        }

    }
}
