# 삽질 일기🔨

## Spring : Localhost DB로 연결 불가 - Mysql Version 문제

### 문제
> 01-Sep-2018 11:33:33.983 심각 [RMI TCP Connection(2)-127.0.0.1] org.apache.tomcat.jdbc.pool.ConnectionPool.init Unable to create initial connections of pool.
 com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Could not create connection to database server.

- 외부 DB 서버로는 데이터 베이스 연결이 잘 되었는데, localhost DB로 연결이 되지 않았다.
- 설정 현황
```
  spring-jdbc-version : 5.0.4.RELEASE
  jdk version : 1.8
  tomcat version : 8.5.23
  mysql version : 8.0.12 
```

### 해결
- mysql version을 5.7로 낮춰서 다시 설치하였다.
- mysql version 8은 처음으로 스크립트방식으로 만든 것이기 때문에 이에 맞는 드라이브를 고르라고 한다.
