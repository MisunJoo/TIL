package my.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExam03 {
    public static void main(String[] args){


        //2. 커넥션과 관련된 interface를 선언한다.
        //   JDBC URL은 DBMS마다 형식이 다르다.
        //   커넥션은 반드시 finally 에서 close한다.
        Connection conn =  null;

        //3. SQL을 실행하기 위한 interface를 선언한다.
        PreparedStatement ps = null;

        //4. 결과를 읽어오기 위한 interface를 선언한다.
        ResultSet rs = null;
        try{
            //1. Driver를 등록한다.
            Class.forName("org.h2.Driver");

            //5. SQL 준비한다.
            String sql = "SELECT role_id, description FROM ROLE where role_id = ?";

            // a. DB에 연결한다.
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1",
                    "sa", "");

            // db에 sql을 준비해달라고 한다.
            // ps는 db안에서 준비된 sql을 참조하는 변수.
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 500); // 바인딩 한다.

            // 준비된 sql을 실행하게 한다. 실행한 결과는 dbms에 있다.
            // rs는 실행된 결과를 참조하는 변수
            // executeQuery() : select문 실행, executeUpdate() : insert, update, delete
            rs = ps.executeQuery();

            // 한건의 data를 읽어온다. 한건의 data는 여러개의 컬럼으로 구성되어 있다.
            // next()가 호출되면 한건의 읽어오는데 그 결과는 ResultSet이 가지고 있다.
            if(rs.next()){
                int roleId = rs.getInt(1); // 첫번째 칼럼의 값을 정수로 읽어온다.
                String description = rs.getString(2); // 두번째 칼럼은 문자열로 읽어온다.
                System.out.println(roleId + ", " + description);
            }else{
                System.out.println("data가 없습니다.");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                rs.close();
            }catch(Exception ex){}
            try {
                ps.close();
            }catch(Exception ex){}
            try {
                conn.close();
            }catch(Exception ex){}
        }
    }
}
