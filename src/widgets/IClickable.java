package widgets;

public interface IClickable {
    //클릭할 수 있는 위젯들은 IClickable 인터페이스를 상속
    void onClick();// 이 인터페이스에는 onClick() 메서드만 있음
} // 이 인터페이스를 구현하는 위젯은 반드시 onClick() 메서드를 오버라이딩 해야 함.
// 그리고 위젯을 클릭하면 이 메서드가 호출됨.