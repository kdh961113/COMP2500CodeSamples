package graphics;

public class Point extends Graphic{ //Point는 Graphic 클래스를 상속함
    private int x;
    private int y;

    public Point(String label, int x, int y) {
        super(label);
        this.x = x;
        this.y = y;
    } //생성자 선언

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    //getter와 setter

    public void draw() {
        System.out.printf("Draw point '%s'%s",
                this.label,
                System.lineSeparator());
    }
    // void 형 매서드, 이 매서드가 캔버스 위에 점을 하나 그린다고 상상하자

}
