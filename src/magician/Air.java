package magician;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public final class Air extends Attunement{//Air 조율
    private final int ELITE_SKILL_COOLDOWN_SECS = 80;

    public Air(Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("As fast as lightning!");
    }

    public void attack() {
        System.out.println("Electric whip!");
    }// onEntry()와 attack() 매서드의 구현이 다름

    public void useEliteSkill(final OffsetDateTime lastEliteAttackUsedDateTime) {
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        final Duration cooldown = Duration.ofSeconds(ELITE_SKILL_COOLDOWN_SECS);
        final OffsetDateTime cooldownExpiryDateTime = lastEliteAttackUsedDateTime.plus(cooldown);

        if (now.compareTo(cooldownExpiryDateTime) > 0) {
            System.out.println("You will be zapped!");
            System.out.println("1 million volt lightning!");
            // 엘리트 공격은 100만 볼트 전격
        } else {
            System.out.println("I can't use this yet!");
        }
    }

    public void onDeath() {
        System.out.println("I am wind...");

    }

}
