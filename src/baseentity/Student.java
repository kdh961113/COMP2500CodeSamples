package baseentity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Student extends BaseEntity {
    private String name;
    private String email;
    private String nickname;
    //private 멤버 변수들

    public Student(UUID id,
                   OffsetDateTime createdDateTime,
                   OffsetDateTime modifiedDateTime,
                   String name,
                   String email,
                   String nickname) {
        super(id, createdDateTime, modifiedDateTime);
        this.name = name;
        this.email = email;
        this.nickname = nickname;
    } //생성자

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
    //name과 email의 getter

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    //nickname의 getter와 setter
}
