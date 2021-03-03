package copyconstructor;

public final class Program {
    public static void main(String[] args) {
        final Point p1 = new Point(1, 1);// 새로운 점 개체를 만듦
        final Point p2 = new Point(p1);
        //복사 생성자를 사용해서 복사

        p1.setX(-4);
        p1.setY(-8);
        //위에서 한것이 깊은 복사인지 확인하기 위해서 p1의 x와 y값을 변경한다.

        System.out.printf("p1.x: %d, p1.y: %d%s",
                p1.getX(),
                p1.getY(),
                System.lineSeparator());  //p2의 값도 바뀌었는지 확인
        System.out.printf("p2.x: %d, p2.y: %d%s",
                p2.getX(),
                p2.getY(),
                System.lineSeparator()); //바꾸지 않았다. 여전히 x = 1, y = 1이다.
      

        final Point p3 = new Point(5, 7);

        final Line l1 = new Line(p2, p3);
        final Line l2 = new Line(l1);
        //p2, p3을 이용해서 선분 개체 l1을 만들고 복사 생성자를 통해 12를 생성
        
        p2.setX(10);
        p2.setY(15);
        //p2의 x, y값을 변경

        System.out.printf("l1.p1.x: %d, l1.p1.y: %d%s",
                l1.getP1().getX(),
                l1.getP1().getY(),
                System.lineSeparator());//l1의 p1은 여전히 x = 10, y = 15

        System.out.printf("l1.p2.x: %d, l1.p2.y: %d%s",
                l1.getP2().getX(),
                l1.getP2().getY(),
                System.lineSeparator()); // l2의 p1은 여전히 x = 1, y = 1
                //깊은 복사가 제대로 되었다.

        System.out.printf("l2.p1.x: %d, l2.p1.y: %d%s",
                l2.getP1().getX(),
                l2.getP1().getY(),
                System.lineSeparator());

        System.out.printf("l2.p2.x: %d, l2.p2.y: %d%s",
                l2.getP2().getX(),
                l2.getP2().getY(),
                System.lineSeparator());
    }
}
