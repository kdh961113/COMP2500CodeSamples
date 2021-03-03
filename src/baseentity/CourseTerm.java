package baseentity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class CourseTerm extends BaseEntity { //BaseEntity를 extends(상속)하는 CourseTerm 선언
    private int term; // 멤버 int형 변수 term 선언
    private Course course; // 멤버 변수 course 선언
    private ArrayList<Student> students; // 멤버 배열 선언 course 선언
    //한 학기에 해당 과목을 수강하는 학생이 여럿 있음
    

    public CourseTerm(UUID id, OffsetDateTime createdDateTime, OffsetDateTime modifiedDateTime, Course course, int term) {
        super(id, createdDateTime, modifiedDateTime);
        //개체 CourseTerm를 선언, 부모의 값을 참조를 선언 
        this.course = course; // 생성자 course를 선언
        this.term = term; // 생성자 term를 선언
        this.students = new ArrayList<>(); // 생성자 students를 초기화
    }

    public int getTerm() {
        return this.term;
    } // 생성자 term를 return하는 int형 개체 선언
    //학기(term)의 getter

    public Course getCourse() { // 생성자 course를 return하는 개체 선언
        return this.course;
    }// course의 getter

    public ArrayList<Student> getStudents() {
        return this.students;
    } // 생성자 students를 return 하는 멤버 배열 변수 선언 
    // students의 getter

    public void setStudents(ArrayList<Student> students) { // 생성자 student를 초기화해주는 void 멤버 변수 선언
        this.students = students;
    } // 마지막으로 students의 setter

    // helper methods
    public void addStudent(Student student) {
        this.students.add(student);
    }
    //생성자 student에 add(student)를 대입하는 void 개체 선언

    public int getStudentCount() {
        return this.students.size();
    }
    //생성자 students의 사이즈 값을 return하는 int형 개체 선언
    // 학생을 추가하고 학생 수를 찾는 도우미 메서드
}
