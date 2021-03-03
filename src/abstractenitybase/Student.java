package abstractenitybase;

import java.time.OffsetDateTime;
import java.util.UUID;

public final class Student extends BaseEntity {
    //Student Class는 바뀐 것이 없다. 추상 클래스를 확장하는 건 일반적인 Class를 확장하는 것과 다르지 않음.
    private String name;
    private String email;
    private String nickname;

    public Student(final UUID id,
                   final OffsetDateTime createdDateTime,
                   final OffsetDateTime modifiedDateTime,
                   final String name,
                   final String email,
                   final String nickname) {//매개변수에 final 키워드를 추가함.
        super(id, createdDateTime, modifiedDateTime); // 그리고 여전히 super()를 사용 할 수 있다.
        this.name = name;
        this.email = email;
        this.nickname = nickname;
    }

    public String getName() {
        return this.name;
    } //getter 생성

    public void setName(final String name) {
        this.name = name;
    }//getter 생성

    public String getEmail() {
        return this.email;
    }//getter 생성

    public void setEmail(final String email) {
        this.email = email;
    }//getter 생성

    public String getNickname() {
        return this.nickname;
    }//getter 생성

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }//setter 생성
}
