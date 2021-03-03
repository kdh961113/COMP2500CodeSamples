package graphics;

import java.util.ArrayList;

public class Picture extends Graphic{ //Picture Class는 Graphic을 상속
    // 그림은 여러 Graphic 개체들을 합친 것임
    // Picture는 Graphic과의 관계가 is-a, has-a 둘 다 성립함
    private ArrayList<Graphic> graphics;
    // 따라서 Graphic 개체들을 저장할 리스트가 필요
    public Picture(String label) {
        super(label);

        this.graphics = new ArrayList<>();
    } //생성자 선언


    public void add(Graphic graphic) {
        this.graphics.add(graphic);
    } // void형 add 매서드(개체)는 그림 속에 어떤 Graphic 개체라도 추가 할 수 있게 해줌

    public void draw() {
        int count = this.graphics.size();

        if (count <= 0) {
            return;
        } // 그래픽 리스트(ArrayList<Graphic>)가 비어있다면 아무것도 그릴 게 없으니 그냥 일찍 반환

        System.out.printf("Draw picture '%s'%s",
                this.label,
                System.lineSeparator());

        for (int i = 0; i < count; ++i) { // 그렇지 않다면 그 리스트를 순회함
            Graphic g = this.graphics.get(i);
            Class c = g.getClass();
            String className = c.getSimpleName();
            //현재 그래픽 개체의 Class 이름을 찾는다.

            switch (className) {
                case "Circle":
                    ((Circle) g).draw();
                    break;
                    // Class 이름에 따라 Graphic 개체를 올바른 형으로 변한 한 뒤, draw() 메서드(개체)를 호출한다

                case "Point":
                    ((Point) g).draw();
                    break;

                case "Line":
                    ((Line) g).draw();
                    break;

                case "Picture":
                    ((Picture) g).draw();
                    break;

                    // Point, Lina, Picture도 마친가지임.
                default:
                    String message = String.format("Unknown graphic type %s", className);
                    throw new IllegalArgumentException(message);
            }
        }
    }
}
