package graphics;

public class Line extends Graphic{ //Line Class도 Graphic을 상속함
    private Point p1;
    private Point p2;
    //Point 개체 2개가 들어있음. 당연히 선분은 2개의 점으로 이루어져 있기 때문

    public Line(String label,
                Point p1,
                Point p2) {
        super(label);
        this.p1 = p1;
        this.p2 = p2;
    } //생성자 선언

    public double getLength() {
        int xDiff = this.p1.getX() - this.p2.getX();
        int yDiff = this.p1.getY() - this.p2.getY();

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    } // 선분의 길이를 구하는 단순한 메서드(double형 개체)

    public void draw() {
        System.out.printf("Draw line '%s'%s",
                this.label,
                System.lineSeparator());
    } //Line 클래스도 캔버스에 그리려면 draw() void 매서드(개체)가 필요.
}
