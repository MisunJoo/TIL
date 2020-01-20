
# 부스트코스 iOS프로그래밍 
## 1. 음원재생기 애플리케이션

### delegate
#### delegate를 쓰는 과정
1. delegate를 채택
2. 위임자 지정 (ViewController에서 self는 viewController)
3. 위임한 것을 대신해주는 함수를 구현

### closure
```
{ (매개변수들) -> 반환 타입 in 실행코드}
```
in은 정의부와 실행부를 분리하기 위히여 사용

### AutoLayout
##### Center-X Anchor, Center-Y Anchor, Bottom Anchor, Top Anchor
출처 : https://medium.com/@hassanahmedkhan/autolayouts-via-layout-anchors-5214b3f746a9

### 애플 문서 읽는 법
1. Guid for iOS 읽기 (https://developer.apple.com/library/archive/navigation/)
2. 참조문서 읽기 (https://developer.apple.com/documentation)
3. 기능별 유의
    - 프로퍼티 : 속성, 정렬 등
    - 메서드 : 기능 재정의
    - 부모클래스 : 원하는 프로퍼티나 메서드가 없다면
    - 델리게이트 : 특정 이벤트가 발생하는 것을 감지 -> 프로토콜 문서 살펴보기
