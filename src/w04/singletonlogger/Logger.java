package w04.singletonlogger;

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

public class Logger { //class Logger 선언
    private static final String CONFIG_FILENAME = "logger-config.txt";

    private static Logger instance;
    //Logger 인스턴스에 사용할 정적 변수를 추가했다. Logger 클래스의 인스턴스는 최대 1개만 있을 수 있음
    //싱글턴 Class용으로 만드는 것

    private LogLevel logLevel;
    private BufferedWriter outBuffer;
    //loglevel과 outBuffer가 더 이상 정걱 멤버 변수가 아님, 그 대신 인스턴스 멤버 변수가 됨

    private Logger(LogLevel logLevel, String outputPath) {
        this.logLevel = logLevel;

        try {
            this.outBuffer = new BufferedWriter(new FileWriter(outputPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }// 생성자는 여전히 private. 하지만 멤버 변수들을 초기화하는 코드가 추가됨

    public static Logger getInstance() { //설정 파일을 읽는 것은 getInstance() 메서드 안에서 할 것임
        if (instance != null) {
            return instance;
        }//만약 Logger 클래스의 인스턴스를 이미 만든 적이 있다면 그걸 그대로 반환

        try {
            String classPath = getClassPath();
            Path loggerConfigPath = Paths.get(classPath, CONFIG_FILENAME);

            File configFile = new File(loggerConfigPath.toString());

            LogLevel logLevel = LogLevel.WARNING;
            String outputFilename = "log.txt";
            //아니라면 설정을 읽음. 이건 정적 Logger에서 봤던 코드와 같음(약간의 변수만 바뀜)


            if (configFile.isFile()) {
                List<String> lines = Files.readAllLines(loggerConfigPath, StandardCharsets.UTF_8);

                for (String line : lines) {
                    String[] splits = line.split("=");

                    switch (splits[0]) {
                        case "loglevel":
                            logLevel = LogLevel.valueOf(splits[1]);
                            break;

                        case "output":
                            outputFilename = splits[1];
                            break;

                        default:
                            throw new IllegalArgumentException("Unknown configuration setting: " + splits[0]);
                    }
                }
            }

            Path path = Paths.get(classPath, outputFilename);
            String pathString = path.toString();

            instance = new Logger(logLevel, pathString);
            return instance;
            //설정을 로딩한 후에는 Logger 클래스의 인스턴스를 만들고 정적 변수에 대입. 그리고 반환
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteInstance() {
        if (this.outBuffer != null) {
            try {
                this.outBuffer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (instance != null) {
            instance = null;
        }
    } //deleteInstance()는 outBuffer를 닫고 그 인스턴스를 null로 바꿈.
    // 정적 Logger에 있던 close() 메서드와 같은 개념

    public void logDebug(String message, Object... args) {
        writeToFile(LogLevel.DEBUG, message, args);
    } //logDebug() 메서드
    //더 이상 assert를 사용하지 않음. Logger 인스턴스를 만들지 않은 채 이 메서드를 호출할 수 없기 때문.


    public void logInformation(String message, Object... args) {
        writeToFile(LogLevel.INFORMATION, message, args);
    }

    public void logWarning(String message, Object... args) {
        writeToFile(LogLevel.WARNING, message, args);
    }

    public void logError(String message, Object... args) {
        writeToFile(LogLevel.ERROR, message, args);
    }

    public void logCritical(String message, Object... args) {
        writeToFile(LogLevel.CRITICAL, message, args);
    }

    private void writeToFile(LogLevel logLevel, String message, Object... args) {
        if (this.logLevel.getLogLevel() > logLevel.getLogLevel()) {
            return;
        }

        try {
            String log = String.format("[%s] %s: %s",
                    Instant.now().toString(),
                    logLevel.toString(),
                    String.format(message, args));
            this.outBuffer.write(log);
            this.outBuffer.newLine();
            this.outBuffer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getClassPath() {
        File f = new File(Logger.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = Logger.class.getPackageName();
        packageName = packageName.replace('.', '/');

        Path p = Paths.get(f.getPath(), packageName);

        return p.toAbsolutePath().normalize().toString();
    }
}
