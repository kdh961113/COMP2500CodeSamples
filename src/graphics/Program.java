package graphics;

public class Program {
    public static void main(String[] args) {
        Point p1 = new Point("Point 1", 2, 7);
        Point p2 = new Point("Point 2", 1, 8);
        //Point 개체 2개를 만듦

        p1.draw();
        p2.draw();
        // 이들을 그릴려면 draw() 메서드(개체)를 호출하면 됨
        
        System.out.println("----------------------------");

        Line l1 = new Line("Line 1", p1, p2);
        // 이미 2개의 점이 있으니 선분을 쉽게 만들 수 있음
        

        l1.draw();

        System.out.println("----------------------------");

        Circle c1 = new Circle("Circle 1", p1, 5);
        Circle c2 = new Circle("Circle 2", p2, 10);
        /// 원들을 만들고 그려봄
        
        c1.draw();
        c2.draw();

        System.out.println("----------------------------");

        Picture pic1 = new Picture("Picture with a line and a circle");
        // 그림 개체 생성, 선과 원이 하나씩 들어있는 그림
        pic1.add(c1);
        pic1.add(l1);
        //원과 선을 그림에 추가한다.

        pic1.draw();
        // 이걸 그리면(실행) 하면 원과 선을 볼 수 있다!

        System.out.println("----------------------------");

        Picture pic2 = new Picture("More complicated pic");
        
        pic2.add(pic1);
        pic2.add(c2);
        // 이처럼 그림은 다른 그림의 일부가 될 수도 있음
        
        pic2.draw();
        //이건 pic1을 그린 뒤, 원(c2)을 그림(실행)

        System.out.println("----------------------------");

        Picture pic3 = new Picture("Even more complicated pic");

        pic3.add(pic1);
        pic3.add(pic2);
        // 마지막으로 여러 개의 그림으로 이루어진 그림도 만들 수 있음.
        pic3.draw();
        // 이걸 그리면 pic1과 pic2가 모두 그려짐!
        //pic3.draw()는 사실 컴포지트 디자인 패턴의 한 예
        //여러 개체를 모아놓은 것을 동일한 형으로 처리해야 할 때 매우 유용함
    }
}
