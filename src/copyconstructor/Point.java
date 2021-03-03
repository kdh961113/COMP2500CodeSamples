package copyconstructor;

public final class Point { //복사생서자는 COMP3200에서 자세히 배우는 주제이다.
    //그러나 이것도 개체를 깊게 복사하는 방법 중 하나이니 여기서 잠깐보자.
    private int x;
    private int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Point(final Point other) {
        this(other.x, other.y);
    }//복사생성자 선언함.
    //Point 개체를 인자로 받는 생성자
    //other.x와 other.y를 사용하여 다른 생성자를 호출하면 끝!


    public int getX() {
        return this.x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(final int y) {
        this.y = y;
    }
}
