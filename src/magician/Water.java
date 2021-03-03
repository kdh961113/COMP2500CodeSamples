package magician;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public final class Water extends Attunement{ //Wather 조율
    private final int ELITE_SKILL_COOLDOWN_SECS = 75;// 쿨 다운 시간 75초

    public Water(final Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("Water! The giver of life!");
    }

    public void attack() {
        System.out.println("Water gun!");
    } // onEntry()와 attack() 구현도 다름

    public void useEliteSkill(final OffsetDateTime lastEliteAttackUsedDateTime) {
        //useEliteSkill()의 로직은 Fire의 그것과 같음
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        final Duration cooldown = Duration.ofSeconds(ELITE_SKILL_COOLDOWN_SECS);

        final OffsetDateTime cooldownExpiryDateTime = lastEliteAttackUsedDateTime.plus(cooldown);

        if (now.compareTo(cooldownExpiryDateTime) > 0) {
            System.out.println("Alright, let's surf!");
            System.out.println("Poseidon's fury! Tsunami~~~!!");
            // 그러나 물 원소의 엘리트 공격은 다름. 파이어 스톰이 아니라 모든 걸 쓸어버리는 쓰나미 공격!
        } else {
            System.out.println("I can't use this yet!");
        }
    }

    public void onDeath() {
        System.out.println("Help! I can't swim!");
    } // 마법사는 수영을 못 하기에 사망 시 물속으로 가라앉음...
}
