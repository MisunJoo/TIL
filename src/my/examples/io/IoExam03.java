package my.examples.io;


import java.io.*;

public class IoExam03 {
    public static void main(String[] args) throws Exception{
        String str = "HelloWorld!";
        byte[] buffer = str.getBytes();

        InputStream in = new ByteArrayInputStream(buffer);
        OutputStream out = new FileOutputStream("/Users/misun/tmp/buffer.txt");

        CopyUtil.copy(in, out);

        InputStream in2 = new FileInputStream("/Users/misun/tmp/buffer.txt");
        OutputStream out2 = new ByteArrayOutputStream();

        CopyUtil.copy(in2, out2);

        byte[] result = ((ByteArrayOutputStream) out2).toByteArray();
        String str2 = new String(result);
        System.out.println(str2);



    }
}
