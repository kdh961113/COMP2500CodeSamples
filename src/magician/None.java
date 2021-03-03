package magician;

import java.time.OffsetDateTime;

    public final class None extends Attunement{ // 기본 조율 자료형 Attunement 클래스를 확장(상속)
        public None(Magician magician) {
            super(magician);
        } // super()를 호출하는게 끝

        public void onEntry() {
            System.out.println("No attunement? Seriously? How am I even supposed to fight?");
        } // 마법사가 원소 조율을 None으로 바꾸는 순간 불평을 할 것임.

        public void attack() {
            System.out.println("Punch!");
        }// 그러나 맨주먹으로 싸울 수는 있음!

    public void useEliteSkill(final OffsetDateTime lastEliteAttackUsedDateTime) {
        System.out.println("What elite attack? You expect me to punch monsters to death?");
    }// 엘리트 공격도 별로 멋지지 않음.None 조율을 사용하는 동안에는 엘리트 공격도 없다고 불평을 하는 마법사를 볼 수 있다.
    // 또한 None 조율을 사용하는 동안은 쿨 다운 시간도 없음

    public void onDeath() {
        System.out.println("I'll be back...");
    } // 사망 시 마법사는 다시 돌아오겠다고 말함
}
