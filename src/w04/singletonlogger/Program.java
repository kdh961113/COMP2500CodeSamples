package w04.singletonlogger;

public class Program {
    public static void main(String[] args) {
        try {
            Logger logger = Logger.getInstance();
            //logger-confing.txt에서 LogLevel이 ERROR로 설정되어 있음.

            logger.logDebug("Printed if the minimum log level is DEBUG");

            logger.logInformation("Printed if the minimum log level is INFORMATION or lower");

            logger.logWarning("Printed if the minimum log level is WARNING or lower");

            logger.logError("Printed if the minimum log level is ERROR or lower");

            logger.logCritical("Printed if the minimum log level is CRITICAL or lower");

            int x = 10;
            int y = 20;

            logger.logDebug("%d * %d = %d",
                    x, y, x * y);

            logger.logInformation("%d * %d = %d",
                    x, y, x * y);

            logger.logWarning("%d * %d = %d",
                    x, y, x * y);

            logger.logError("%d * %d = %d",
                    x, y, x * y);

            logger.logCritical("%d * %d = %d",
                    x, y, x * y);

            logger.deleteInstance(); //사용을 마친 후에는 인스턴스를 지움. 보통 프로그램 제일 마지막에 함
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

