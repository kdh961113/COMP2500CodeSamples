package widgets;

public final class Card extends Widget implements IDraggable{
    //Card는 콘텐츠를 담는 위젯. 화면에서 이 위젯을 끌어 옮길 수 있음.
    //따라서 Widget을 상속하고 IDraggable을 구현
    private String content;

    public Card(int x, int y) {
        super(x, y);
    }

    public Card(String label, int x, int y) {
        super(label, x, y);
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }
    //그리고 content 멤버 변수의 getter와 setter도 여기 있다.

    @Override
    public void onDrag(int x, int y) { //onDrag() 메서드를 오버라이딩하는 것을 잊으면 안됨.
        System.out.printf("Drag Card %s from [ %d, %d ] -> [ %d, %d ]!%s",
                this.label,
                this.x,
                this.y,
                x,
                y,
                System.lineSeparator());

        this.x = x;
        this.y = y;
        //여기서 하는 일은 위젯의 x,y 위치를 새로운 값으로 업데이트 하는게 전부이다.
    }
}
