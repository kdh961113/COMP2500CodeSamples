package staticlogger;

public enum LogLevel { //열거형
    DEBUG(0),
    INFORMATION(1),
    WARNING(2),
    ERROR(3),
    CRITICAL(4);
    //각 열거형 값에 정수를 대입했기에 비교 연산자를 사용할 수 있다.

    private int level; //멤버 변수 선언

    public int getLogLevel() { // 멤버 변수 선언
        return this.level;
    }

    private LogLevel(int level) { // 멤버 변수 선언
        this.level = level;
    }
    // 이런 일을 할려면 private 멤버 변수, getter 메서드, private 생성자가 필요
}


