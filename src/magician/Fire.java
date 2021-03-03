package magician;


import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public final class Fire extends  Attunement{//fire 조율,
    private final int ELITE_SKILL_COOLDOWN_SECS = 90; //90초 동안

    public Fire(final Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("I am fire! Burn everything to the ground!");
    }// 이 조율로 변경하는 순간 마법사는 멋진 말을 함. 몸에서 불꼿이 솟구치면서 이 말을 한다고 상상해보면 나름 멋진데...?


    public void attack() {
        System.out.println("Fire~~~ Ball~~~~~!!!");
    } //Fire 조율을 사용할 때 기본 공격은 파이어 볼

    public void useEliteSkill(final OffsetDateTime lastEliteAttackUsedDateTime) {
        // 엘리트 공격은 파이어 스톰이다. 이 공격은 너무나도 막강하기에 쿨 다운에 걸림
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        final Duration cooldown = Duration.ofSeconds(ELITE_SKILL_COOLDOWN_SECS);

        final OffsetDateTime cooldownExpiryDateTime = lastEliteAttackUsedDateTime.plus(cooldown);
        //이것과 lastEliteAttackUsedDateTime을 사용하면 쿨 다운이 끝나는 시간을 계산 할 수 있다.

        if (now.compareTo(cooldownExpiryDateTime) > 0) {
            // 그 결과를 현재 시간과 비교하면 끝
            // 여기서 0보다 크다는 것은 현재 시간이 cooldownExpiryDateTime 보다 후라는 뜻
            System.out.println("Burn everything to cinders!");
            System.out.println("Fire~~~~ Storm~~~~!!!!");
            // 쿨 다운이 끝났으면 파이어 스톰 주문을 시전
        } else {
            System.out.println("I can't use this yet!");
            //그렇지 않다면 사용 불가
        }
    }

    public void onDeath() {
        System.out.println("I will rise again like a phoenix...");
    } // 사망시 마법사가 재가 되어버림.
}
