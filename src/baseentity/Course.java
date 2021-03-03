package baseentity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.UUID;

public class Course extends BaseEntity { //이제 Course 클래스는 BaseEntity를 상속함
    private String courseCode; // String형 멤버 변수 선언
    private String title;   //Stirng형 멤버 변수 선언
    private ArrayList<CourseTerm> courseTerms; // 멤버 변수 배열 선언
    //Course는 여러 CourseTerm 개체들을 가지고 있음. 과목은 하나지만 여러 학기에 개설되기 때문
    //그리고 자신만의 private 멤버 변수도 가진다.

    public Course(UUID id, //Course 생성자 선언
                  OffsetDateTime createdDateTime,
                  OffsetDateTime modifiedDateTime,
                  //생정자 인자로는 id, createdDateTime, modifiedDateTime를 받아서 부모 생성자에 전달 해줘야 함
                  String courseCode,
                  String title) { //그리고 courseCode와 title을 받아 자기 자신의 멤버 변수도 초기화함
        super(id, createdDateTime, modifiedDateTime); //super는 부모 개체를 의미. 이건 부모 클래스의 생성자를 호출 하고 있는 모습
        this.courseCode = courseCode;
        this.title = title;
        this.courseTerms = new ArrayList<>();
        //과목이 처음 생성될 때는 아직 그 과목이 개설된 학기가 없음. 따라서 빈 리스트를 대입해준다.
        //자기 자신의 멤버 변수의 값을 초기화
    }

    public String getCourseCode() { //setter가 없는 멤버 변수
        return this.courseCode;
        //클래스에 어떤 멤버 변수의 setter가 없다면 개체를 생성한 후에는 이 멤버 변수의 값을 변경하기 말아야 한다는 것이 힌트
        //따라서 courseCode는 생성자에서 값을 대입한 이후에는 절대 변경되지 않을 것임
    }

    public String getTitle() {
        return this.title;
    } // 생성자 title을 return하는 멤버 함수를 선언

    public void setTitle(String title) {
        this.title = title;
    } //생성자 title을 초기화하는 void 개체를 선언

    public ArrayList<CourseTerm> getCourseTerms() {return this.courseTerms;} 
    // 생성자 courseTerms를 return하는 배열 멤버 변수 선언

    public void setCourseTerms(ArrayList<CourseTerm> courseTerms) {
        this.courseTerms = courseTerms;
    }
    //생성자 courseTerms를 초기화하는 void 생성자 선언
    // helper methods
    public void addCourseTerm(int term) { //Course 개체에 CourseTerm을 추가하는 도우미(helper) 메서드
        CourseTerm courseTerm = new CourseTerm(UUID.randomUUID(),
                OffsetDateTime.now(ZoneOffset.UTC),
                OffsetDateTime.now(ZoneOffset.UTC),
                this,
                term);

        this.courseTerms.add(courseTerm); //이 메서드가 있으면 Course 개체에 CourseTerm을 추가하는게 매우 깔끔해짐
    }
}
