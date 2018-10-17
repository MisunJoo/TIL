package my.examples.io;

import java.io.*;

// 키보드로부터 한줄씩 입력받아서 파일에 한줄씩 출력하시오.
// quit 라고 입력을 하면 프로그램은 종료됩니다.\
// 1. 어디서 읽어들이지? 키보드 (System.in : 표준입력 InputStream)
// 2. 어디에 쓰는 거지? 파일 (FileWriter : 파일에 char단위 출력)
// 3. 읽는 방법 : 한줄씩 입력받는다. // BufferedReader : Reader
// 4. 쓰는 방법 : 한줄씩 쓴다. // PrintWriter : Writer
public class IoExam05 {
    public static void main(String[] args){
        BufferedReader br = null; //readLine() : 한 줄 씩 읽어들이는 메소드
        PrintWriter pw = null; //println()을 가지고 있음

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(new FileWriter("/Users/misun/tmp/read.txt"));

            String line = null;
            int count = 1;
            while ((line = br.readLine()) != null) {
                if ("quit".equals(line)) break;

                pw.println(count + ":" + line);
                count++;
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (Exception ex){}
            try{
                pw.close();
            }catch (Exception ex){}

        }


    }
}
