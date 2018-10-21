package my.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCExam01 {
    public static void main(String[] args) throws Exception{
        //1. Driver를 등록한다.
        Class.forName("org.h2.Driver");

        //2. 커넥션을 연결한다. (DB와 접속한다.)
        //   JDBC URL은 DBMS마다 형식이 다르다.
        //   커넥션은 반드시 finally 에서 close한다.
        Connection conn =  null;
        try{
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1",
                    "sa", "");
            System.out.println("성공!");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            conn.close();
        }
    }
}
