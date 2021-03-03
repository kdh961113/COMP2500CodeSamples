package classinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Program {
    public static void main(String[] args) { // 정적 출력 메인 함수 선언
        Vector vector = new Vector(2, 5); //벡터 개체 선언
        //Java의 RTTI를 사용해서 실행 중에 클래스 정보를 찾는 법, 간단한 백체 개체

        Class vectorClass = vector.getClass();
        //getClass()를 호출해서 Class 개체를 얻어옴. 이 메서드는 Object 클래스 안에 선언되어 있고
        //Object 클래스는 java의 모든 클래스가 자동으로 상속함

        System.out.printf("Package name: %s%s",
                vectorClass.getPackageName(),
                System.lineSeparator());
        //Class.getPackageName() 메서드는 클래스의 전체 패키지 이름을 반환, classinfo

        System.out.printf("Type name: %s%s",
                vectorClass.getTypeName(),
                System.lineSeparator());
        //Class.getTypename() 메서드는 클래스의 전체 이름을 반환, 여기서 반한된 값은 classinfo.Vector

        Method[] methods = vectorClass.getMethods();
        //또한 클래스 안에 선언된 메서드의 리스트를 찾을 수도 있다.
        //Class.getMethods()는 해당 클래스 안에서 선언된 메서드 외에도 조상 클래스로 부터 상속한 메서드도 포함

        System.out.printf("# methods: %d%s",
                methods.length,
                System.lineSeparator());
        

        methods = vectorClass.getDeclaredMethods();
        //상속된 메서드들을 제외하려면 Class.getDeclaredMethods() 메서드를 사용해야함

        System.out.printf("# declared methods: %d%s",
                methods.length,
                System.lineSeparator());
        // 이경우 메서드 수가 5이다.

        for (Method m : methods) {
            System.out.printf("    - %s%s",
                    m.getName(),
                    System.lineSeparator());
        } // 메서드들의 이름을 출력

        try {
            Method method = vectorClass
                    .getMethod("toString");
            //Class.getMethod() 메서드는 현재 클래스와 그 조상을 검색

            System.out.println(method.toString());
            //메서드 이름으로 매서드를 찾을 수도 있다.
            //Object 클래스 안에 toString() 메서드가 선언되아 있으니 이 메서드를 성공적으로 찾았음
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Method method = vectorClass
                    .getDeclaredMethod("toString");

            System.out.println(method.toString());
            //그러나 Class.getDeclaredMethod() 메서드를 사용하여 Vector 클래스 안만 찾으면...
        } catch (NoSuchMethodException e) {
            System.out.println("No such method!");
            //toString() 메서드는 못 찾는다.
        }

        try {
            Method method = vectorClass.getDeclaredMethod("changeName");
            //존재하지 않는 메서드를 찾을려고 해도

            System.out.println(method.toString());
        } catch (NoSuchMethodException e) {
            System.out.println("No such method!");
            //찾을 수가 없다.
        }

        try {
            Method method = vectorClass.getDeclaredMethod("add", Vector.class);

            System.out.println(method.toString());
            //또한 특정 매개변수를 받는 매서드를 찾을 수도 있다.
            //동일한 이름을 가진 메서드가 여러 개 있을 때(오버로딩)에 유용
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Field[] fields = vectorClass
                .getDeclaredFields();
        //Class.getDeclaredFilelds() 메서드는 클래스의 모든 멤버 변수를 반환, private 멤버 변수 까지 반환

        System.out.printf("# member vars: %d%s",
                fields.length,
                System.lineSeparator());
        //Vector 클래스에는 2개의 멤버 변수가 있다.

        Class objectClass = vectorClass
                .getSuperclass();
        //Class.getSuperclass()를 사용하면 어떤 클래스의 부모 클래스도 구할 수 있음.

        System.out.printf("Superclass: %s%s",
                objectClass.getTypeName(),
                System.lineSeparator());
        //여기서 나오는건 당연히 Object 클래스
    }
}
