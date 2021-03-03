package staticlogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

public class Logger { //Logger는 파일에 로그를 남길 수 있게 해주는 간단한 클래스
    // 정걱(static) 메서드만 사용해서 구현해 볼 것임.

    private static final String CONFIG_FILENAME = "logger-config.txt";
    // 상수의 문자열로 선언한 정적 멤버 변수
    //텍스트 파일로 부터 설정을 읽어옴. 이 파일은 로그 할 메세지의 최소 레벨과 출력 파일의 이름을 지정
    //밑에 나머지 멤버 변수들은 모두 클래스에 소속됨.

    private static LogLevel logLevel = LogLevel.WARNING; // 정적 멤버 변수(메소드)
    //LogLevel은 열거형으로 각 로그 메시지가 얼마나 긴급한지 나타냄.
    //모든 로그 메시지에는 LogLevel이 같이 들어옴
    //LogLevel은 다음 중 하나: DEBUG, INFORMATION, WARING, ERROR, CRTITCAL
    // CRITICAL은 가장 긴급한 로그 레벨, 가장 안 급한것은 DEBUG
    // logLevel 멤버 변수는 이 로그가 출력할 최소 LogLevel을 의미
    //만약 logLevel이 WARNING이라면 WARNING보다 긴급도가 낮은 로그 메시지들은 출력 파일에 안적힘
    
    private static boolean isConfigLoaded = false;
    //정적 boolean 맴버 변수
    //로그 메시지를 남기려면 그 전에 설정을 읽어야함. 따라서 이거는 일단 false로 초기화

    private static BufferedWriter bufferOut;
    //정적 멤버 변수 선언
    //BufferedWriter는 스트림에 텍스트를 쓸 수 있게 해줌

    //멤버 변수들을 정의. 모든 멤버 변수들은 정적으로 설정됨
    //정적 메서드 안에서는 정적 멤버 변수만 사용 가능

    private Logger() {
    } // 생성자는 private. 이 클래스의 인스턴스를 만드는 것은 허용하지 않음.

    public static void loadConfig() { //정적 멤버 함수, loadConfing() 메서드는 파일로 부터 설정을 읽음
        try { //자바의 예외 처리문. try는 프로그램이 끝날 때 닫혀야 하는 (clase) 개체
            String classPath = getClassPath(); // 이것은 Logger.class가 위치한 디렉터리의 경로를 가져옴
            Path loggerConfigPath = Paths.get(classPath, CONFIG_FILENAME);

            File configFile = new File(loggerConfigPath.toString());
            String outputFilename = "log.txt";
            // 이것이 기본 출력 파일 이름. 설정 파일에 출력 파일 이름이 지정되어 있지 않으면 이 이름을 대신 사용
            // 파일을 읽기 위해 Path와 File 개체를 설정
            //추가 설명: 경로의 어디에 있는 파일을 구해오는 것, 경로 구해온 다음에 그 경로와 합쳐서 파일을 불러오는 것

            if (configFile.isFile()) { // logger-confing.txt가 존재하고, 이게 유요한 파일이면...
                List<String> lines = Files.readAllLines(loggerConfigPath, StandardCharsets.UTF_8);
                // 그 파일의 모든 내용을 읽어옴

                for (String line : lines) { //for문
                    String[] splits = line.split("="); // 문자열 배열 splits 선언

                    switch (splits[0]) { //switch문
                        case "loglevel":
                            logLevel = LogLevel.valueOf(splits[1]);
                            break;

                        case "output":
                            outputFilename = splits[1];
                            break;

                        default:
                            throw new IllegalArgumentException("Unknown configuration setting: " + splits[0]);
                            //throw 객체 선언
                            //이 파일 내용은 각 줄마다 키-값의 쌍이 들어있고, 키와 값은 '-' 문자로 분리되어 있음, 이렇게 각 설정 값을 읽음
                    }
                }
            }

            Path path = Paths.get(classPath, outputFilename); //문자열 classPath와 outputFilename을 path 생성자를 생성 및 대입
            String outputPath = path.toString(); // 문자열 outputPath는 path 생성자에 문자열 대입 한 값

            bufferOut = new BufferedWriter(new FileWriter(outputPath));
            //문자열 outputPath에서 새로운 FileWriter 개체를 할당하고 새로운 BufferedWriter를 할당하여 선언하고
            //생성자 bufferOut에 대입
            // 설정을 읽은 뒤에는 BufferWriter 개체를 만듦

            isConfigLoaded = true; 
            //정적 맴버 변수 isCongfigLoaded에 true 값 대입
            // 설정하였다고 ture 값으로 설정
        } catch (IOException e) {
            throw new RuntimeException(e);
        } // 여기에 있는 try/catch문은 파일 입출력 메서드 때문임(예: Files.readAllLines())
        //Files.readAllLines()는 파일을 읽다가 오류가 생기면 IOException을 던짐
        //여기서 예외를 잡은(catch) 뒤 unchecked 예외로 바꿔버림. 예외에 대해서는 일간 무시 할 것.
    }

    public static void close() { // 정적 멤버 함수 선언
        if (bufferOut != null) { //if문, bufferOut 생성자의 값이 null이 아니라면
            try {
                bufferOut.close(); //생성자 bufferOut에 close를 대입
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    } // BufferedWriter는 언매니지드 리소스라서 GC가 자동으로 닫아주지 않음. 따라서 이걸 직접 닫아줄 메서드가 필요

    public static void logDebug(String message, Object... args) { //정적 void 멤버 함수 logDebug 선언
        assert (isConfigLoaded) : "Configuration not loaded"; // isConfingLoaded가 true인지 어서트로 확인
        writeToFile(LogLevel.DEBUG, message, args); // writeToFile()은 이 메시지를 bufferOut에 작성하는게 전부
    } // logDebug()는 DEBUG 레벨 메시지를 작성. 만약 logLevel 멤버 변수가 WARNING이라면 이 메서드는 출력 파일에 아무것도 작성하지 않음

    public static void logInformation(String message, Object... args) { // 정적 void 맴버 함수 선언
        assert (isConfigLoaded) : "Configuration not loaded";
        writeToFile(LogLevel.INFORMATION, message, args);
    } //logInfermation()은 INFORMATION 레벨 메시지를 작성

    public static void logWarning(String message, Object... args) { // 정적 멤버 함수 선언
        assert (isConfigLoaded) : "Configuration not loaded";
        writeToFile(LogLevel.WARNING, message, args);
    } //logWaring()은 WARNING 레벨 메시지를 작성

    public static void logError(String message, Object... args) { // 정적 멤버 함수 선언
        assert (isConfigLoaded) : "Configuration not loaded";
        writeToFile(LogLevel.ERROR, message, args);
    } //logError()은 ERROR 레벨 메시지를 작성

    public static void logCritical(String message, Object... args) {// 정적 멤버 함수 선언
        assert (isConfigLoaded) : "Configuration not loaded";
        writeToFile(LogLevel.CRITICAL, message, args);
    }//logCritical()은 CRITICAL 레벨 메시지를 작성

    private static void writeToFile(LogLevel logLevel, String message, Object... args) {
        //정적 void 멤버 함수 선언

        if (!isConfigLoaded || Logger.logLevel.getLogLevel() > logLevel.getLogLevel()) {
            return; // 설정을 읽은 적이 없거나 Logger의 logLevel이 현재 메시지의 logLevel보다 크면 출력 파일에 아무것도 남기지 않음
        }

        try {
            String log = String.format("[%s] %s: %s",
                    Instant.now().toString(),
                    logLevel.toString(),
                    String.format(message, args));
            bufferOut.write(log);
            bufferOut.newLine();
            bufferOut.flush(); // 그게 아니라면 출력 파일에 메시지를 쓴다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getClassPath() { // 정적 String 맴버 함수
        File f = new File(Logger.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = Logger.class.getPackageName();
        packageName = packageName.replace('.', '/');

        Path p = Paths.get(f.getPath(), packageName);

        return p.toAbsolutePath().normalize().toString();
    } // confing이 로딩된 상황에서만 writing을 하고,그게 아니라면 return하는데, 그 외에 또 return.
    //// 그 외에 지금 들어온 log 레벨이 내가 지금 이 log에서 허용하는 log 레벨 보다 우선 순위가 낮으면 아무것도 적지 않겠다. 하고 return 함
}
