package widgets;

public interface IDraggable {// 드래그 할 수 있는 위젯은 IDraggable 인터페이스를 상속
    void onDrag(int x, int y);
    //IDraggble을 구현하는 클래스는 반드시 onDrag() 메서드를 오버라이딩해야 함.
} // 위젯을 끌면 이 위젯의 x,y 위치가 onDrag() 메서드에 전달 됨.
