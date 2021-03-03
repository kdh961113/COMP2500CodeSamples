package magician;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public final class Magician {
    //final을 선언 하였으므로 다형적으로 사용하는 클래스는 아님
    // 마법사는 4대 원소(공기, 물, 불, 흙)의 마스터
    //마법사는 원소 조율(elemental attunement)을 자유롭게 바꿔가며 적에게 다양한 마법을 시전함
    
    private String name;
    private Attunement attunement;
    //마법사는 이름과 현재 원소 조율을 가짐
    private OffsetDateTime lastEliteAttackUsedDateTime;
    // 마지막에 엘리트 공격을 사용했던 시간을 기억. 엘리트 공격은 쿨다운 시간이 있음.
    //이 변수를 사용하여 마법사가 엘리트 공격을 사용할 수 있는지를 판단 할 것임

    public Magician(String name) {
        this.name = name;
        this.attunement = new None(this);
        // 기본 조율은 None
        this.lastEliteAttackUsedDateTime = OffsetDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        // 그리고 lastEliteAttackUsedDatatTime을 서기 1년 1월 1일로 초기화
    }   // 마법사(Magican) 생성자

   public String getName() {
        return this.name;
    }

    public void setAttunement(final Attunement attunement) {
        if (this.attunement.getClass() != attunement.getClass()) {
            // 조율을 바꿔야 할 때만 바꿈
            this.attunement = attunement;
            this.attunement.onEntry();
            //따라서 onEntry()는 조율이 바뀔때 마다 호출됨.
            //나중에 보듯이 각 조율은 onEntry()를 다르게 구현
            //이건 마법사가 사용하는 원소를 바꿀때 마다 하는 행동이라 생각하길.
            //예를 들어 마법사는 불 원소를 바꾸는 순간 몸 주위에 불꼿이 이글거리게 할 수 있음...
            
        }
    } // 조율의 setter 메서드

    public void attack() {
        this.attunement.attack();
    } // 마법사는 공격을 할 수 있다. 각 조율마다 공격이 달라지니 현재 조율 개체의 attack() 메서드에 이 동작을 맡김

    public void useEliteSkill() {
        this.attunement.useEliteSkill(this.lastEliteAttackUsedDateTime);
        this.lastEliteAttackUsedDateTime = OffsetDateTime.now(ZoneOffset.UTC);
    }

    public void onDeath() {
        this.attunement.onDeath();
        this.lastEliteAttackUsedDateTime = OffsetDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        //조율 개체의 useEliteSkill() 매서드에 lastEliteAttackUsedDateTime을 전달하고 현재 시간을 저장
        //마법사가 죽을 때 이 메서드가 호출됨. 역시 현재 원소 조율에 따라 다른 행동을 함
        //예를 들어 불 조율을 사용하는 마법사는 죽을 때 쟤가 되어버릴 지도?
        //죽으면 엘리트 공격의 쿨 다운 시간도 리셋됨
    }
}
