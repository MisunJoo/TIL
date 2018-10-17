package my.examples.io;

import java.io.InputStream;
import java.io.OutputStream;

//바이트 크기 버퍼가 1024라는 크기를 정의하는 Util

public class CopyUtil {
    public static void copy(InputStream in, OutputStream out){
        try{
            byte[] buffer = new byte[1024];
            int readCount = 0;

            while((readCount = in.read(buffer)) != -1){
                out.write(buffer, 0, readCount);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                in.close();
            }catch (Exception ex){ }
            try{
                out.close();
            }catch (Exception ex){ }
        }
    }
}

