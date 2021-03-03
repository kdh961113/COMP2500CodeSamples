package staticlogger;

public class Progream {
    public static void main(String[] args) { //정적 멤버 함수 선언, 문자열을 출력하는 함수임
        try {
            Logger.loadConfig(); // 우선 loadConfing()을 호출하여 설정을 읽어옴
            //해당 예제에서 logLevel은 INFORMATION, 출력 파일명은 static-log.txt로 설정되어 있음

            Logger.logDebug("Printed if the minimum log level is DEBUG");
            // 최소 logLevel이 INFORMATION이니 이건 출력 파일에 저장 안됨

            Logger.logInformation("Printed if the minimum log level is INFORMATION or lower");
            // 출력 파일에 저장 됨.

            Logger.logWarning("Printed if the minimum log level is WARNING or lower");

            Logger.logError("Printed if the minimum log level is ERROR or lower");

            Logger.logCritical("Printed if the minimum log level is CRITICAL or lower");
        
            // 위에 3개 모두 출력 파일에 저장됨

            int x = 10;
            int y = 20;

            Logger.logDebug("%d * %d = %d",
                    x, y, x * y);

            Logger.logInformation("%d * %d = %d",
                    x, y, x * y);

            Logger.logWarning("%d * %d = %d",
                    x, y, x * y);

            Logger.logError("%d * %d = %d",
                    x, y, x * y);

            Logger.logCritical("%d * %d = %d",
                    x, y, x * y);

            Logger.close();
            // 로그 메서드에 사용한 가변 인자 덕에 서식 문자를 이용해서 로그를 남길 수도 있다.
            // 하지만 logDebug를 제외하고 나머지들은 출력 파일에서 볼 수 있음
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
