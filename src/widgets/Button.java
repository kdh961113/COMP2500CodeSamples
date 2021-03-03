package widgets;

public final class Button extends Widget implements IClickable {
    //Button은 클릭할 수 있는 위젯이니 Widget을 상속하고 IClickable을 구현해야 함.
    public Button(int x, int y) {
        super(x, y);
    }

    public Button(String label, int x, int y) {
        super(label, x, y);
    }

    @Override
    public void onClick() {
        System.out.printf("Button %s clicked!%s",
                this.label,
                System.lineSeparator());
    }//따라서 onClick() 메서드를 오버라이딩
    //인터페이스에 선언된 메서드를 오버라이딩하지 않음녀 컴파일 오류가 발생함.
}
