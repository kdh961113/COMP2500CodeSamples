package baseentity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class Program {
    public static void main(String[] args) { // 출력문 메인 함수 선언
        UUID id = UUID.randomUUID(); // UUID 정격 함수를 사용하는 배열 선언
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        Student student1 = new Student(id,
                now,
                now,
                "Tom",
                "Smith",
                "tommy hammer");
        //새로운 학생을 만듦, 배열 선언

        printStudentInformation(student1); //학생 정보 출력
        //id, createdDateTime, modifiedDateTime과 name, email, nickname이 올바르게 출력되는지 확인

        id = UUID.randomUUID(); // UUID 정격 함수를 사용하는 배열 선언
        now = OffsetDateTime.now(ZoneOffset.UTC);

        BaseEntity student2 = new Student(id,
                now,
                now,
                "Kevin",
                "Park",
                "KtotheP");
        //이번에는 다른 학생의 인스턴스를 만드는데 그 인스턴스를 BaseEntity 형의 변수의 대입해 보자
        //Student는 (여전히) BaseEntity 이기에 가능한 일!(is-a)
       
        //그러나 student2에서 printStudentInformation() 메서드를 호출하려 하면 컴파일 오류가 남

        printStudentInformation((Student) student2); 
        //따라서 printStudentInformation()을 호출하기 전에 student2를 Student로 캐스팅해야함

        ((Student) student2).setNickname("KevinInThePark");
        //student2에서 setNickname()을 호출하려고 해도 역시 Student로 캐스팅해야 함

        now = OffsetDateTime.now(ZoneOffset.UTC);
        student2.setModifiedDateTime(now);
        //그러나 student2에서 곧바로 setModifieddateTime()을 호출 할 수 는 있다.
        //이 메서드는 BaseEntity 클래스에 선언되어 있기 때문

        printStudentInformation((Student) student2);
        //student2의 별명(nickname)이 "KevinInThePark"으로 바뀌었음

        id = UUID.randomUUID(); //UUID의 정격 사용하는 배열 선언
        now = OffsetDateTime.now(ZoneOffset.UTC);

        Course comp2500 = new Course(id,
                now,
                now,
                "COMP2500",
                "Java"); //Course 개체를 생성

        id = UUID.randomUUID(); //UUID의 정격 사용하는 배열 선언
        now = OffsetDateTime.now(ZoneOffset.UTC);

        CourseTerm term202005 = new CourseTerm(id,
                now,
                now,
                comp2500,
                202005); // CourseTrem 개체를 생성

        comp2500.getCourseTerms().add(term202005);
        //comp2500에 term202005를 추가

        printCourseInformation(comp2500);
        //comp2500을 출력해 보면 term202005가 성공적으로 추가되었음을 볼 수 있음

        comp2500.addCourseTerm(202009);
        // 그 대신 addCourseTerm() 도우미 메서드를 사용하여 다른 학기를 추가 할 수도 있다.

        printCourseInformation(comp2500);

        term202005.addStudent(student1);
        term202005.addStudent((Student) student2);
        //이제 term202005에 학생들을 등록시켜 볼 차례

        comp2500.setTitle("Object Oriented Programming and Design (Java)"); //그리고 과목명릅 바꾼다.

        printCourseInformation(comp2500); // comp2500을 출력해 과목명이 바뀌었는지, 학생들이 해당 학기에 등록되어있는지 확인
    }

    private static void printStudentInformation(Student student) { //정적 멤버 void 함수 선언, Student형의 인자의 값을 받는 함수
        System.out.println("student:"); //이것은 printStudentInformation()가 Student 형의 인자를 받기 때문

        printBaseEntityInformation(student);

        System.out.printf ("    name: %s%s",
                student.getName(),
                System.lineSeparator());

        System.out.printf("    email: %s%s",
                student.getEmail(),
                System.lineSeparator());

        System.out.printf("    nickname: %s%s",
                student.getNickname(),
                System.lineSeparator());
    }

    private static void printCourseInformation(Course course) { //정적 멤버 void 함수 선언, Course 형의 인자의 값을 받는 함수
        System.out.println("course:");

        printBaseEntityInformation(course);

        System.out.printf("    course code: %s%s",
                course.getCourseCode(),
                System.lineSeparator());

        System.out.printf("    title: %s%s",
                course.getTitle(),
                System.lineSeparator());

        System.out.println("    course terms:");

        for (CourseTerm courseTerm : course.getCourseTerms()) {
            System.out.printf("        term: %s%s",
                    courseTerm.getTerm(),
                    System.lineSeparator());
            System.out.printf("        # students: %s%s",
                    courseTerm.getStudentCount(),
                    System.lineSeparator());
        }
    }

    private static void printBaseEntityInformation(BaseEntity entity) {
        // 정걱 void 멤버 함수 선언, BaseEntity 형의 인자를 받는 함수
        System.out.printf("    id: %s%s",
                entity.getID(),
                System.lineSeparator());

        System.out.printf("    created: %s%s",
                entity.getCreatedDateTime(),
                System.lineSeparator());

        System.out.printf("    modified: %s%s",
                entity.getModifiedDateTime(),
                System.lineSeparator());
    }
}
