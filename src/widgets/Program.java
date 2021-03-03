package widgets;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        final Button button1 = new Button("Button1", 10, 5);
        final Button button2 = new Button("Button2", 5, 0);
        // 버튼 개체들을 생성
        final Card card1 = new Card("Card1", 0, 1);
        final Card card2 = new Card("Card2", -10, -1);
        // 카드 개체들을 생성
        final Directory directory1 = new Directory("New Folder1", 5, 9);
        final Directory directory2 = new Directory("New Folder2", 12, 22);
        // 디렉터리 개체들을 생성
        final ArrayList<Widget> widgets = new ArrayList<>();
        //버튼, 카드, 디렉터리는 모두 위젯이니 모두 하나의 리스트에 추가 할 수 있음.
        widgets.add(button1);
        widgets.add(button2);
        widgets.add(card1);
        widgets.add(card2);
        widgets.add(directory1);
        widgets.add(directory2);
        //형 변환은 필요 없음.
        for (Widget widget : widgets) { //이제 이 리스트들을 순회한다.
            System.out.printf("Widget label: %s%s",
                    widget.getLabel(),
                    System.lineSeparator());
            //각 위젯에서 getLabel()과 같은 메서드를 호출 할 수 있음.

            // Compile Error
            // widget.onClick();
            // widget.onDrag(10, 14);
            // widget.onDropped(card1);
            //그러나 인터페이스의 메서드를 호출하는 것은 불가능하다.
            //왜냐하면 final ArrayList<Widget> widgets = new ArrayList<>();
            //에서 리스트의 사용한 자료형이 Widget이고 Widget은 어떤 인터페이스도 구현하지 않기 때문
        }

        final IClickable clickableButton = (IClickable) widgets.get(0);
        clickableButton.onClick();
        //인터페이스 매서드를 호출하면 이것처럼 위젯을 그 인터페이스로 형 변환하거나
        System.out.println("----------------");

        final ArrayList<IClickable> clickables = new ArrayList<>();
        // 클릭 가능한 개체들만 따로 리스트에 저장하는 것처럼 인터페이스별로 리스트를 만들어 둠.
        clickables.add(button1);
        clickables.add(button2);
        clickables.add(directory1);
        clickables.add(directory2);
        //클릭 가능한 개체들을 추가한다. 버튼과 디렉터리 모두 클릭 가능하니 형 변환을 안 해도 됨.

        // Compile Error
        // clickables.add(card1);
        //그러나 카드를 clickables에 추가할 수 없음. 컴파일 오류 발생

        // Compile error
        // clickables.add((IClickable) card2);
        // Card는 IClickable을 구현하지 않으니 card2를 IClickable로 형 변환 할 수 없다.
        for (IClickable clickable : clickables) {
            clickable.onClick();
        } //clickables 리스트를 순회하며 클릭 가능한 각 위젯의 onClick() 메서드를 호출

        System.out.println("----------------");

        final ArrayList<IDraggable> draggables = new ArrayList<>();

        draggables.add(card1);
        draggables.add(card2);
        draggables.add(directory1);
        draggables.add(directory2);
        //드래그 가능한 위젯에서도 이런 일을 해보자.
        final Random random = new Random(10);
        //난수 발생기에서 구한 x,y값을 onDrag()메서드에 전달할 것임.
        for (IDraggable draggable : draggables) {
            int x = random.nextInt(50);
            int y = random.nextInt(50);

            draggable.onDrag(x, y);
        } // 드래그 가능한 각 위젯에서 onDrag()을 호출

        System.out.println("----------------");

        final ArrayList<IDroppable> droppables = new ArrayList<>();

        droppables.add(directory1);
        droppables.add(directory2);

        for (IDroppable droppable : droppables) {
            droppable.onDrop(button1);
        } //끌어다 놓을 수 있는 위젯도 마찬가지
    }
}
