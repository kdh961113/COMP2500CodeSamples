package abstractenitybase;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import  java.util.UUID;

public class Program {
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        //새로운 UUID와 현재 시간을 많듦.

        // Compile error
        // final BaseEntity entity = new BaseEntity(id, now, now);
        //위의 것은 컴파일 오류가 난다. 추상 클래스의 인스턴스를 만들 수 없음.
        final BaseEntity student1 = new Student(id,
                now,
                now,
                "Peter Parker",
                "peter.parker@pocu.academy",
                "Spider Man");
        //따라서 이것처럼 구체 Class의 생성자를 이용해야 함.

        System.out.printf("id: %s%s",
                student1.getID(),
                System.lineSeparator());
        System.out.printf("createdDateTime: %s%s",
                student1.getCreatedDateTime(),
                System.lineSeparator());
        System.out.printf("modifiedDateTime: %s%s",
                student1.getModifiedDateTime(),
                System.lineSeparator());
        // 추상 Class에서 id, createDateTime, modifiedDateTime을 제대로 출력 할 수 있나 확인 중
        System.out.printf("name: %s%s",
                ((Student) student1).getName(),
                System.lineSeparator());
        System.out.printf("email: %s%s",
                ((Student) student1).getEmail(),
                System.lineSeparator());
        System.out.printf("nickname: %s%s",
                ((Student) student1).getNickname(),
                System.lineSeparator());
        //Student Class에 선언된 메서드들을 호출 하려면 student1을 Student 형으로 변환해야 함.
        // name, email, nickname이 출력됨.
        System.out.println("---------------");

        id = UUID.randomUUID();

        final Student student2 = new Student(id,
                now,
                now,
                "Tony Stark",
                "tony.stark@pocu.academy",
                "Iron Man");
        //이번에는 구체 Class 형인 Student Class를 사용하여 student2 개체를 생성해 보자.

        System.out.printf("id: %s%s",
                student2.getID(),
                System.lineSeparator());
        System.out.printf("createdDateTime: %s%s",
                student2.getCreatedDateTime(),
                System.lineSeparator());
        System.out.printf("modifiedDateTime: %s%s",
                student2.getModifiedDateTime(),
                System.lineSeparator());
        //id, createdDateTime, modifiedDateTime이 제대로 출력 됨.
        System.out.printf("name: %s%s",
                student2.getName(),
                System.lineSeparator());
        System.out.printf("email: %s%s",
                student2.getEmail(),
                System.lineSeparator());
        System.out.printf("nickname: %s%s",
                student2.getNickname(),
                System.lineSeparator());
    } //name, email, nickname도 제대로 출력
}
