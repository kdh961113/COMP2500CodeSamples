package copyconstructor;

public class Line {
    private final Point p1;
    private final Point p2;

    public Line(final Point p1,
                final Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(final Line other) {
        this(new Point(other.p1),
                new Point(other.p2));
    } //Line 클래스의 복사 생성자
    //Point 복사 생성자를 만들었으니, Point의 복사 생성자를 호출하고,
    //2개가 생성니 되니, 그것으로 Line을 생성하면 됨.
    //여기서 반드시 Point 클래스의 복사 생성자를 호출해야 함.
    //p1,p2는 참조형이니 여기서 this(other.p1, other.p2)만 호출하면 이건 Point 개체를 앝게 복사할 것임.
    //진정한 깊은 복사는 Point 클래스의 복사 생성자를 사용함.

    public double getLength() {
        int xDiff = this.p1.getX() - this.p2.getX();
        int yDiff = this.p1.getY() - this.p2.getY();

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public Point getP1() {
        return this.p1;
    }

    public Point getP2() {
        return this.p2;
    }
}
