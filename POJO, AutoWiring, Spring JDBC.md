> 동적 바인딩 : 함수가 어디에서 호출되었는가. 메소드가 같은 이름이라도 인자나 리턴값에 따라서 동적으로 호출되니, 호출될 때 그 메소드를 참조. 
>
> 정적 바인딩  : 컴파일 시에  참조변수와 인스턴스를 연결. 실행시에 연결을 변경할 수 없다.

의존성 주입방법 : 생성자 기반 의존성 주입 방식(constructor-based dependency injection)

### POJO

다른 라이브러리나 프레임워크에 종속적이지 않은 객체

Ex) 인터페이스를 구현한 객체는 pojo가 아니다.

### AutoWiring

@ComponentScan() : package 이하에서 @Component 자동으로 bean으로 등록

Optional<UserService> userService

includeFilters(기본 스캔대상 외에 다른 컴포넌트를 포함 하고 싶을 경우)

excludeFilters('' 제외'')


### Spring JDBC

@import는 또다른 javaConfig를 읽어들인다는 뜻

?대신에 :id 가들어간다.

바인딩할 정보를 갖고있는 map을 만들어줘서, key는 id

BeanPropertySqlParameterSource(board)

jdbc.queryForObject: 딱 한건 조회 - Collections.singletonMAp

jdbc.update : 입력수정삭제

rowMapper : id컬럼을 board의 setid에넣어주라는 규칙을 제공

::: read_count => setReadCount 이렇게 매핑이 되어야한다.



jdbc.queryForObject

? 부분을 param으로 바인딩하고, mapper로 객체를 준다. (resultSet을 짤라오는 코드가 안에 들어가있다.)
