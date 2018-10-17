package my.examples.io;

import java.io.*;

//정수, 문자열, 실수 등 read —> 정수, 문자열, 실수 등 write (DataInputStream, DataOutputStream)
public class IoExam06 {
    public static void main(String[] args) {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream("/Users/misun/tmp/data.bin"));
            out.writeBoolean(true);
            out.writeInt(4);
            out.writeDouble(24.34324);
            out.writeUTF("하이루!!!!");

            in = new DataInputStream(new FileInputStream("/Users/misun/tmp/data.bin"));
            boolean flag = in.readBoolean();
            int i = in.readInt();
            double d = in.readDouble();
            String str = in.readUTF();

            System.out.println(flag);
            System.out.println(i);
            System.out.println(d);
            System.out.println(str);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                out.close();
            }catch (Exception ex){}
            try {
                in.close();
            }catch (Exception ex){}
        }
    }
}
