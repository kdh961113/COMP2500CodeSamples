package widgets;

public interface IDroppable {// 다른 위젯을 끌어다 놓을 수 있는 위젯은 IDroppable 인터페이스를 상속
    void onDrop(Widget widget); //IDroppable을 구현하는 클래스는 onDrop() 메서드를 오버라이딩 해야함.
}// 어떤 위젯 위에 끌어다 놓은 위젯이 onDrop() 메서드의 인자로 들어온다.
