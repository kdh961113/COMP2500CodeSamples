package graphics;

public class Circle extends Graphic { //Circle도 Graphic 클래스를 상속
    private Point center;
    private int radius;
    // 원은 중점과 반지름으로 정의함

    public Circle(String label,
                  Point center,
                  int radius) {
        super(label);
        this.center = center;
        this.radius = radius;
    } //생성자 선언


    public double getCircumference() {
        return 2 * radius * Math.PI;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    } // 원의 둘레와 면적을 구하는 메서드(개체)

    public void draw() {
        System.out.printf("Draw circle '%s'%s",
                this.label,
                System.lineSeparator());
    } // 또 다른 void형 draw() 메서드(개체)
}
