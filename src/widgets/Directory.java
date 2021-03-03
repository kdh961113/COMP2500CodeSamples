package widgets;

public final class Directory extends Widget implements IClickable, IDraggable, IDroppable{
    //Directory는 클릭, 드래그, 드롭을 모두 할 수 있는 위젯
    //따라서 3개의 인터페이스를 모두 구현함. widget을 상속하는건 말할 필요도 없음.
    public Directory(int x, int y) {
        super(x, y);
    }

    public Directory(String label, int x, int y) {
        super(label, x, y);
    }

    @Override
    public void onClick() {
        System.out.printf("Directory %s clicked!%s",
                this.label,
                System.lineSeparator());
    } //onClick()을 오버라이딩

    @Override
    public void onDrag(int x, int y) {
        System.out.printf("Drag Directory %s from [ %d, %d ] -> [ %d, %d ]!%s",
                this.label,
                this.x,
                this.y,
                x,
                y,
                System.lineSeparator());

        this.x = x;
        this.y = y;
    } //onDrage()을 오버라이딩

    @Override
    public void onDrop(Widget widget) {
        System.out.printf("Widget %s was dropped inside of Directory %s%s",
                widget.getLabel(),
                this.label,
                System.lineSeparator());
    } //onDrop()도 오버라이딩
}
