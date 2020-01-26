### Activity 

- Activity란 하나의 화면

### Context

- 애플리케이션 환경에 대한 전역정보
- 리소스 및 클래스에 대한 접근
- activity의 실행과 브로드캐스팅
- Intent 수신

- **View.getContext() **

  **현재 활성화되어 있는 View의 Context를 얻을 때 사용**된다.

  해당 클래스 내에서 this로도 참조가 가능하다.

- **ContextWrapper.getBaseContext() **

  **다른Activity의 Context에 접근****할 때 **사용**된다.

-  **Activity.getApplicationContext()**

  **Application 자체 즉, 서비스의 Context**를 얻을 수 있다.

  출처: https://secuinfo.tistory.com/entry/Android-Develop-getContext-getApplicationContext-getBaaseContext [Song's Lab]

## Recycler View

#### 워크플로우

1. Activity_main.xml에 RecyclerView 추가
2. 리사이클러뷰의 내부를 구성하는 singer_item.xml 아이템 뷰 레이아웃 추가
3. 리사이클러뷰 어댑터 구현 extends RecyclerView.Adapter
4. 어댑터, 레이아웃 매니저 지정 setAdapter(), setLayoutAdapter





1. 리스트에 필요한 뷰 홀더 (각 한줄)를 생성 (유저가 스크롤로 또다른 데이터를 가져올 때, 기존에 생성한 뷰 홀더를 재활용)
2. 화면에서 아이템(데이터) 의 변경사항이 있을 경우, RecyclerView.Adapter.notify()로 어댑터에게 알려줘야 함



- Adapter 
  - 리사이클러뷰에 표시될 아이템 뷰를 생성. 사용자 데이터로붙커 아이템뷰를 만듦
  - 각 뷰홀더를 관리
  - 어댑터가 필요한 만큼 뷰홀더를 생성하고, 뷰 홀더와 안에 표시될 데이터와 연결시켜줌 (뷰홀더 - 어댑터 - 데이터)
  - 뷰 홀더가 필요한 위치에 할당될 떄, 어댑터는 onBindViewHolder() 호출
  - 각 Cell (==viewholder)에 들어갈 데이터를 지정
  - 그 데이터를 onBindViewHolder함수에서 연결
  - 반드시 개발자가 직접 구현
- ViewHolder
  - 화면에 표시될 아이템 뷰를 저장하는 객체
  - 어댑터에서 생성되고, 뷰홀더를 재활용 할 때에는 데이터가 뷰 홀더의 아이템 뷰에 바인딩 됨 
  - 스트에 들어가는 뷰들을 표현. 뷰홀더는 리사이클러뷰에 하나 이상 존재하며 **각 한줄** 을 표현한다. 
- LayoutManager 
  - View를 그리는 방법을 정의
  - [LinearLayoutManager](https://developer.android.com/reference/android/support/v7/widget/LinearLayoutManager.html) : 가로/세로 형태로 아이템을 배치한다.
  - `RecyclerView`는 기본 뷰의 정의가 없기 때문에, 무조건 하나 설정해줘야 한다. 설정하지 않으면 화면이 구성되지 않음
  - 3가지 오버라이딩 메소드(onCreatViewHolder, onBindViewHolder, getItemCount) 및 ViewHolder Class를 갖고 있음
- Item
  - ViewHolder객체에 저장되어 관리되어짐

#### 코드에서의 역할

- MainActivity 

  - 리사이클러 뷰를 연결
  - 레이아웃매니저 선언
  - 어댑터 선언

- Adapter

  - RecyclerView.Adater를 상속받고, 커스터마이징한 클래스를 사용

    ``` java
    public class MyAdapter extends RecyclerView.Adater<MyAdapter.MyViewHolder>
    ```

    | **onCreateViewHolder**(ViewGroup parent, int viewType) | viewType 형태의 아이템 뷰를 위한 뷰홀더 객체 생성.     |
    | ------------------------------------------------------ | ------------------------------------------------------ |
    | **onBindViewHolder**(ViewHolder holder, int position)  | position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시. |
    | **getItemCount**()                                     | 전체 아이템 갯수 리턴.                                 |



참고문헌 : 

https://thdev.tech/androiddev/2016/11/01/Android-RecyclerView-intro/ 

https://g-y-e-o-m.tistory.com/127

https://recipes4dev.tistory.com/154

