package abstractenitybase;

import java.time.OffsetDateTime;
import java.util.UUID;

public abstract class BaseEntity {
    //지난 예제의 경우에는 BaseEntity가 추상 Class가 아니었다.
    //따라서 new BaseEntity(id, datetimeNow, datetimeNow) 같은 코드를 통해 BaseEntity 개체를 만들 수도 있다.
    //그러나 이것은 원하는 바가 아니다. BaseEntity Class는 코드 중복을 막기 위해 있을 뿐.
    //BaseEntity Class의 인스턴스를 만든다고 특별히 유용한 일을 할 수 있는 것도 아니라 정말 도움이 안됨.
    //따라서 이것을 추상 클래스로 만들어 아무도 BaseEntity를 직접 사용할 수 없게 막는게 좋다.
    private final UUID id;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    public BaseEntity(final UUID id,
                      final OffsetDateTime createdDateTime,
                      final OffsetDateTime modifiedDateTime) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }
    //생성자는 바뀐 것이 없다. new BaseEntity(id, datetimeNow, datetimeNow)라는 코드를 사용할 순 없지만
    //여전히 자식 Class에서 super()를 호출하여 이 생성자를 사용할 순 없음.

    public UUID getID() {
        return this.id;
    }//getter 선언

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }//getter 선언

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }//getter 선언

    public void setModifiedDateTime(final OffsetDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    } //setter 선언
}
