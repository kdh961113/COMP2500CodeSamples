package entitycomponentsystn;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        GameObject batman = loadGameObjectOrNull("Batman");
        batman.update();
        // batman 개체 파일은 Component 개체로 역직렬화(deserialize)한 뒤, 그 개체에서 update()를 호출함.
        

        System.out.println();

        GameObject tree = loadGameObjectOrNull("Tree");
        tree.update();

        System.out.println();

        GameObject scaryVampire = loadGameObjectOrNull("ScaryVampire");
        scaryVampire.update();
    }

    private static GameObject loadGameObjectOrNull(String name) {
        //loadGameObjectOrNull()이 역직렬화를 담당
        String directory = getClassPath();
        String filename = String.format("%s.txt", name);
        Path filepath = Paths.get(directory, filename);
        File playerFile = new File(filepath.toString());
        //일단 텍스트 파일의 전체 경로를 찾음

        if (!playerFile.isFile()) {
            return null;
        } // 만약 파일이 없다면 역직렬화도 못하니 null을 반환

        List<String> lines;

        try {
            lines = Files.readAllLines(filepath,
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } // 파일의 내용을 읽음

        assert (lines.size() == 1) : "Player setting file is not in correct format!";
        // 파일에 여러 줄이 있다면 assert를 실행
        // 게임 개체 파일이 반드시 한 줄이어야 한다고 알려주는 역할
        String[] components = lines.get(0)
                .split(",", -1);
                //파일의 첫 출을 쉼표(,)에 따라 분리. 각 토큰은 컴포넌트 하나를 나타냄


        GameObject obj = new GameObject(name);

        for (String c : components) { //이제 각 컴포넌트 마다...
            ComponentType type;

            try {
                type = ComponentType.valueOf(c.toUpperCase());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
                //ComponentType 열거형으로 읽음(parse). 만약 읽는 데 실패했다면 이건 모르는 컴포넌트.
                // 따라서 오류를 출력한 뒤, null을 반환
            }

            switch (type) { // 이제 간단히 switch문을 사용하여 컴포넌트를 하나씩 게임 개체에 추가할 수 있다.
                case AI:
                    obj.addComponent(new AiComponent());
                    break;

                case CONTROLLABLE:
                    obj.addComponent(new ControllableComponent());
                    break;

                case PHYSICS:
                    obj.addComponent(new PhysicsComponent());
                    break;

                case ENTITY:
                    obj.addComponent(new EntityComponent());
                    break;

                default:
                    return null;
            }
        }

        return obj;
    }

    private static String getClassPath() {
        File file = new File(Program.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = Program.class.getPackageName();
        packageName = packageName.replace('.', '/');

        Path path = Paths.get(file.getPath(), packageName);

        return path.toAbsolutePath().normalize().toString();
    }
}
