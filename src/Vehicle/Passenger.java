package Vehicle;

public class Passenger { //public 접근 제어자, 붙이지 않으면 다른 패키지에서 이 클래스를 이용 못함
    public String name; // 멤버 변수. 일단 'public' 접근 제어자를 사용 할 것임. 하지만 멤버 변수에는 'public'을 사용하면 안 됨.

    public Passenger(String name)
    //개체 Passenger를 생성, 문자열 name을 정의한다.
    //매개변수를 하나만 받는 생성자를 정의
    // 이렇게 되면 더 이상 기본(default) 생성자를 사용 할 수 없다. 따라서 'new Passenger()'는 컴파일 오류

    {
        this.name = name;
    }
    // 생성자 매개변수 'name'의 값을 멤버 변수 'name'에 대입
    // 'this' 키워드는 현재 개체(현재 사용 즁인 Passenger 인스턴스)를 가리킨다.
    //따라서 'this.name'은 현재 인스턴스의 'name' 멤버 변수를 의미


    public void sayName() {
        System.out.println(String.format("Hi, I'm %s!", this.name));
    }
    // void 객체를
    // 현재 승객의 이름을 출력하는 간단한 메서드
}

