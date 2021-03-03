package widgets;

public abstract class Widget {
    //Java에서 다중 상속하는 법
    //위젯은 그래픽 사용자 인터페이스(GUI)의 요소 중 하나로 정보를 보여주거나
    //사용자가 프로그램과 상호작용 할 수 있는 방법을 제공함
    //아이콘, 버튼, 창, 선택 상자 등이 그 예, 위젯마다 사용자의 행위(예: 클릭, 드래그)에 반응하는 방법이 다름
    //우선 widget은 추상 클래스, 따라서 이 클래스를 그대로 사용하지 못함.
    //이걸 사용하려면 이를 상속하는 구체 클래스가 필요
    private static int numWidgets = 0;

    protected String label;
    //위젯에는 라벨(label)을 나타내는 멤버 변수가 있음. 버튼 위나 창의 젤 꼭대기에 표시되는 텍스트 같은 것
    protected int x;
    protected int y;
    // 이 위젯은 x,y 위치를 기억하는 멤버 변수

    public Widget(final int x,
                  final int y)
    // 생성자 중 하나, 오버로딩된 다른 생성자를 호출
    {
        this(String.format("Widget%d", numWidgets), x, y);
    } // 위쳇의 기본 라벨을 전달한다. numWidgets는 총 생성한 위젯 수를 기억하는 정적 멤버 변수

    public Widget(final String label,
                  final int x,
                  final int y) {
        this.label = label;
        this.x = x;
        this.y = y;
        numWidgets++; //numWidgets의 값도 여기서 증가시킴.
    } // 멤버 변수에 값을 대입한다.

    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    // 나머지 코드는 그냥 getter와 setter들
}
