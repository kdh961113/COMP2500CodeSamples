package graphics;

public class Graphic {// Graphic Class는 화면에 그릴 수 있는 개체들의 기반(base) 클래스
    // 점, 원, 선분, 심지어는 그릴 수 있는 여러 개체들을 모아 놓은 것인 그림도 Graphic 클래스의 자식!
    
    protected String label;

    public Graphic(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    //Graphic Class는 특별한거 없음. 생성자, gettwe, setter가 있는 일반적인 클래스의 모습
}
