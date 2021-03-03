package entitycomponentsystn;

import java.util.ArrayList;

public class GameObject { //파일로 부터 게임 개체를 만드는 방법
    private String name;
    private ArrayList<Component> components = new ArrayList<Component>();

    public GameObject(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    } //생성자 선언, addCoponent()

    public void update() {
        System.out.printf("Update GameObject '%s'%s",
                this.name,
                System.lineSeparator());

        for (Component component : this.components) {
            component.update();
        } // 디버깅 용으로 void형 update 메서드(개체)에서 좀 더 많은 메시지들을 출력

        System.out.printf("Updating '%s' complete%s",
                this.name,
                System.lineSeparator());
    }
}
