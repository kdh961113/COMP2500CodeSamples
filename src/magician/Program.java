package magician;

public class Program {
    public static void main(String[] args) {
        Magician magician = new Magician("Wizard of Oz");

        magician.attack();// 기본 조율은 None이니 이 마법사가 할 수 있는 건 주먹질 뿐
        magician.useEliteSkill(); // 엘리트 공격도 없음
        magician.onDeath();// 죽어도 곧 돌아온다.

        magician.setAttunement(new Fire(magician));
        //조율을 Fire로 변경. onEntry() 메서드가 호출되니 마법사는 모두 다 태워버리겠다고 외칠 것

        magician.attack();// 이제 공격은 파이어 볼
        magician.useEliteSkill();// 엘리트 공격은 파이어 스톰
        magician.onDeath();// 죽으면 불사조 처럼 부활하겠다고 말함

        magician.setAttunement(new Fire(magician));// 현재 조율이 불이니 다시 불로 바꾸면 아무 일도 일어나지 않음
        magician.setAttunement(new Water(magician));// 그러나 물로 바꾸면 Water 조율의 onEntry() 메서드가 실행됨

        magician.attack();// 물 조율의 기본 공격은 물총
        magician.useEliteSkill();//그리고 엘리트 공격은 쓰나미, 만약 onDeath()가 호출되지 않았다면 마법사가 엘리트 기술을 사용하지 못함
        magician.onDeath();// OnDeath() 호출 시 쿨 다운이 리셋되니 이 경우에도 엘리트 기술이 사용됨.

        magician.setAttunement(new Air(magician));

        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();

        magician.setAttunement(new Earth(magician));

        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();

        magician.setAttunement(new None(magician));
        // 조율을 None으로 다시 바꾸면, 마법사가 이래서 어떻게 싸우냐고 불평을 한다.
    }
}
