package baseentity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseEntity { //프로그램을 실행 할 때 각 개체가 고유한 ID를 가지고 있으면 유용한 경우가 있음
    //개체가 생성된 날짜/시간과 마지막으로 수정된 날짜/시간도 꽤 유용한 정보
    //이걸 하는 간단한 방법 중 하나는 만드는 클래스를 만들 때마다 id, createdDateTime, modifiedDateTime 필드를 추가하는 것
    //이 세 필드를 가지는 기반(base) 클래스를 만들고 그로부터 상속을 하면 됨
    private UUID id;
    //id는 UUID(GUID의 다른 이름)로 컴퓨터 시스템에서 어떤 정보에 고유한 식별자를 할당할 때 널리 사용하는 128비트 숫자
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    //3개의 private 필드로 id, createdDatetTime, modifieddataTime이 들어 있음
    //OffsetDateTime은 C#의 DateTimeOffset과 비슷

    public BaseEntity(UUID id, OffsetDateTime createdDateTime, OffsetDateTime modifiedDateTime) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    } //생성자는 멤버 변수들에 값을 대입하는 게 전부, BassEntity는 public 개체

    public UUID getID() {
        return this.id;
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    } //id와 createdDateTime의 getter

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    } //modifiedDateTime의 getter

    public void setModifiedDateTime(OffsetDateTime modifiedDateTime) { //void 개체
        this.modifiedDateTime = modifiedDateTime;
    }   //마지막으로 modifiedDateTime의 setter
        //id와 createdDateTime는 setter가 없다. 개체를 만든 후에 이 값들을 바꿀 수 있다는 건 말이 안됨
}
