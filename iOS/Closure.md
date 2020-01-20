# Closure

##### 코드는 꼭 작성하며 익히기

- 출처 : https://baked-corn.tistory.com/11

```
 func sayHello(name: String) -> String{
     return "Hello \(name)"
 }
```

##### 중괄호 제거
```
 func sayHello(name: String) -> String
 return "Hello \(name)"
```

##### 함수 본체와 반환타입 사시에 in을 추가
```
 func sayHello(name: String) -> String in
```

##### func 키워드와 함수의 이름을 제거
```
 (name: String) -> String in
 return "Hello \(name)"
```

##### 전체를 중괄호로 감싸기
```
 {(name: String) -> String in 
 return "Hello \(name)"
 }
```

##### 변수에 할당 가능!
```
 var sayHello = { (name: String) -> String in 
 return "Hello \(name)"
 }
```

- 출처 : https://yagom.github.io/swift_basic/contents/12_closure/

```
 let sum: (Int, Int) -> Int = { (a: Int, b: Int) in
 return a + b
 }
```
- sum 이라는 상수에, 클로저 (매개변수 타입이 Int, Int이고 반환타입이 Int이다. 그리고 클로저의 정의는 a가 첫 번째 Int 매개변수 b가 두 번째 매개변수이다. 클로저의 내용은 a와 b를 더해 반환하는 것이다.)

```
 let add: (Int, Int) -> Int // 정의부
add = { (a: Int, b: Int) in // 클로저 구현 : 첫 번째 매개변수가 a이고, 두 번째 매개변수가 b이다. 그리고 함수 내의 내용은 a+b 하고 리턴하는 것이다.
    return a + b
}

let substract: (Int, Int) -> Int
substract = { (a: Int, b: Int) in
    return a - b
}

let divide: (Int, Int) -> Int
divide = { (a: Int, b: Int) in
    return a / b
}


// calculate 함수는 매개변수로 Int형 a, Int형 b, 그리고 함수형 method를 갖고 method는 Int형 매개변수 2개를 가지고 Int를 반환한다.
// calculate 함수의 반환값은 method함수의 결과값이다.
// 이렇게 되니 더 유동적인 프로그래밍이 가능하구나.
func calculate(a: Int, b: Int, method: ((Int, Int) -> Int)) -> Int {
    return method(a,b)
}

var calculated: Int
calculated = calculate(a: 50, b: 10, method: add)
print(calculated)

calculated = calculate(a: 50, b: 10, method: { (left: Int, right: Int) -> Int in
    return left * right
})
print(calculated)

// 클로저가 함수의 마지막 전달인자라면 마지막 매개변수 이름을 생략한 후 함수 소괄호 외부에 클로저를 구현할 수 있습니다.
var result: Int
result = calculate(a: 10, b: 10) { (left: Int, right: Int) -> Int in
    return left + right
}
print(result)

result = calculate(a: 10, b: 10, method: {
    return $0 + $1
})
print(result)

result = calculate(a: 10, b: 10) {
    return $0 + $1
}
```


