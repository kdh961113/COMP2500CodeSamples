package magician;

import java.time.OffsetDateTime;

public class Attunement { // Attunement Class는 기반 클래스. 이 클래스의 인스턴스를 만들지는 않을 것임/
    //그 대신 Fire, Water, Air, Earth, None 조율 클래스들을 만들 때 이 클래스를 상속 받음
    protected Magician magician; // 마법사 개체를 가지고 있다.

    public Attunement(final Magician magician) {
        this.magician = magician;
    } // 그리고 생성자는 마법사 개체를 받아서 멤버 변수에 대입하는 게 끝

    public void onEntry() {

    }

    public void attack() {

    }
    // 나머지 메서드들은 그냥 속이 비어있음. 형 변환 없이 조율개체에서
    // 이 메서드들을 직접 호출 할 거라서 이렇게 해야함 

    public void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime) {

    }

    public void onDeath() {

    } // 이렇게 빈 메서드들을 두는 것은 좋은 습관이 아님. 이 클래스는 추상 클래스가 되야함

}
