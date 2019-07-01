# JDBC
 Java DataBase Connectivity의 약자로, 자바 프로그램에서 DB와 관련된 작업을 처리할 수 있도록 도와주는 일을 한다. DBMS의 종류에 상관없이 하나의 JDBC API를 사용하여 데이터베이스 작업을 처리할 수 있다.

### 예제
- 자바에서 오라클을 연결할 때의 상황을 살펴보자. 총 6단계의 과정을 거친다.

## 1. 드라이버 로딩
``` java
    Class.forName("oracle.jdbc.driver.OracleDriver)
```
Class.forName으로 JDBC드라이버를 로딩해준다. 
이 부분은 ClassNotFoundException핸들링을 해주어야 하므로, try-catch문으로 감싸주어야 한다.

## 2. DB 연결
``` java
    Connection conn = null;
    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORA92", "scott", "tiger");
```
Connection을 사용하기 위해서는 java.sql.Connection을 임포트 해주어야 한다. conn이라는 커넥션을 만든 후에 DriverManager의 getConnection을 통해서 DB에 연결해준다. DriverManager를 사용하려면 java.sql.DriverManager를 import 해줘야 한다.
- DriverManager.getConnection의 첫 번째 매개변수 : DB연결. jdbc:oracle:thin:@ 부분은 동일하게 사용하고, localhost라는 위치를 말한다. 다른 PC일 경우는 ip를 입력해주고, 1521은 해당 포트이며, ORA92는 오라클의 SID 이다. 
- DriverManager.getConnection의 두 번째 매개변수 : 오라클의 아이디
- DriverManager.getConnection의 세 번째 매개변수 : 오라클의 패스워드
이 연결부는 SQLException 예외처리로, Try-Catch로 감싸주어야 한다.

## 3. 쿼리 준비
``` java
    PreparedStatement psmt = null;
    psmt = conn.prepareStatement("DB쿼리문");
 ```
 또는

``` java
    Statement stmt = null;
    stmt = conn.createStatement("DB쿼리문");
```
각각 java.sql.PreparedStatement나 java.sql.Statement를 임포트 해주어야 한다. Statement가 PrepatedStatement보다 상위클래스이다.

- PreparedStatement는 쿼리문에 ? 를 사용해서 추가로 ?에 변수를 할당해 줄 수 있다. 
``` java
    psmt = conn.preparedStatement("select * from TableName where id=?");
    psmt.setString(1, id);
```

setString(혹은 setInt 등)을 이용해서 1번째 ? 위치에 id를 할당할 수 있어서 유연성있게 쿼리준비를 할 수 있다.

## 4. 쿼리 실행
``` java
    psmt.excuteUpdate();
```
로 쿼리를 실행한다. insert, update, delete등 값을 받아오지 않는 쿼리문은 excuteUpdate()를 통해 실행해준다.

## 5. 데이터 가져오기
``` java
    ResultSet rs = null;
    rs = psmt.executeQuery();
```
select 등 쿼리 실행 후에 값을 가져와야하는 쿼리문은 위와 같이 java.sql.ResultSet을 이용해 쿼리 실행 결과를 ResultSet으로 받아들인다. 이때 쿼리 실행은 executeQuery()를 사용한다.

그 후,

``` java
    while(rs.next()){
        int i = 1;
        String id = rs.getString(i++);
        String name = rs.getString(i++);
        String addr = rs.getString(i++);
    }
```
rs.next()를 이용해서 실행 결과를 한 줄씩 읽어들인다.
처음에는 시작위치에 있고 rs.next()를 실행하면 받아온 데이터의 첫줄 위치로 이동하게 된다. rs.get을 이용하여 받아온 값을 저장한다. 데이터베이스의 가장 처음 위치는 0이 아니라 1이다. 때문에 i를 1로 초기화해주고, 다음 컬럼을 읽기위해 i++를 해준다. db에 여러줄을 가져올 때는 dto 객체로 받아서 컬렉션 계열로 저장한다.

## 6. 커넥션 닫기
``` java
    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e){
        }
    }

    if (stmt != null) {
        try {
            stmt.close();
        } catch (SQLException e){
        }
    }

    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e){
        }
    }
```
닫을 때는 Open 한 반대의 순서로 닫아주어야 한다. 




 ##### 참고문헌
 - https://sungho88.tistory.com/entry/DataBase-JDBC%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80%EC%9A%94
- https://blog.outsider.ne.kr/6
