# 스프링의 빈 생성
- 1. 내부적으로 리플렉션 API를 이용해서 빈 정의에 나오는 클래스 이름을 가지고 빈 오브젝트를 생성한다. 이때, 디폴트 생성자를 통해 생성한다.
- 2. 팩토리 빈을 통한 생성 : 스프링을 대신해서 오브젝트의 생성로직을 담당하도록 만들어진 특별한 빈
    - 그렇다면 빈을 생성하기 위해 팩토리 빈을 만드는 방법은?
        - FactoryBean 인터페이스를 구현
        ``` java
            public interface FactoryBean<T> {
                T getObject() throws Exception; //빈 오브젝트를 생성해 돌려줌
                Class<? extends T> getObejctType(); // 생성되는 오브젝트의 타입을 알려줌
                boolean isSingleton(); //getObject()가 돌려주는 오브젝트가 항상 같은 싱글톤 오브젝트인지 알려줌
            }
        ```
        - FactoryBean 인터페이스를 구현한 클래스를 스프링의 빈으로 등록하면 팩토리 빈으로 동작한다.
        - 만약 어떤 클래스의 생성자가 private인 경우, 이 클래스는 static 메소드를 통해 생성한다. 즉, 이 클래스를 직접 클래스 명을 통해 스프링 빈으로 등록해서 사용할 수 없다. (사실 리플렉션은 private으로 선언된 생성자 메소드도 접근할 수 있지만 생성자가 private이라는 건 그런 이유가 있을테니 이를 무시하고 오브젝트를 생성하지 않는다.)
        - 일반적으로 private 생성자를 가진 클래스를 빈으로 등록하는 일은 권장되지 않는다.
        - ex) Message라는 private 생성자를 가진 클래스를 빈으로 등록하고 싶다면, MessageFactoryBean 클래스를 정의하고 FactoryBean<Message>를 implement해서 만든다.
        스프링은 FactoryBean 인터페이스를 구현한 클래스가 빈의 클래스로 지정되면, 팩토리 빈 클래스의 오브젝트의 getObject()메소드를 이용해 오브젝트를 가져오고, 이를 빈 오브젝트로 사용한다.