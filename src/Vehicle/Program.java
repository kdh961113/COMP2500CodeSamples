package Vehicle;

import java.util.ArrayList;

public class Program { //클래스 선언
    public static void main(String[] args) { // 정적 멤버 함수 선언 , 출력 멤버 함수임
        Passenger blackWidow = new Passenger("Natasha"); //new 키워드를 사용하여 Passenger class에 대입할 개체 설정.
        blackWidow.sayName(); // sayName() 메서드를 호출하면 블랙 위도우는 본인의 이름을 말함

        Vehicle motorcycle = new Vehicle(VehicleType.MOTORCYCLE);
        // VehicleType Class의 enum MOTORCYCLE을 대입하는 Vehicle의 Class에 속하는 motocycle을 선언.
        motorcycle.addPassenger(blackWidow); //개체 addPassener를 blackWdiow 대입 하여 motocrycle 개체에 대입
        motorcycle.addFuel(22.0 ); 
        // Vehicle Class의 멤버 변수인 fuelAmount에서 22를 대한한 값을 개체 addFule에 대입하고, 다시 그 값을 개체 motocycle에 대입한다.
        //블랙 위도우는 오토바이를 탄다. 휘발유를 22L 줌

        ArrayList<Passenger> taxiPassengers = new ArrayList<Passenger>(); 
        //ArrayList<Passenger>의 개체인 taxiPassengers를 선언하고 AraayList의 배열에 추가한다.
        //(동적 할당)
        taxiPassengers.add(new Passenger("Tony"));
        // Passenger Class에 Tony라는 새로운 변수를 선언 및 대입하여 개체 add를 사용하여 taxiPassenger의 배열에 추가한다.
        taxiPassengers.add(new Passenger("Thor"));
        // Passenger Class에 Tony라는 새로운 변수를 선언 및 대입하여 개체 add를 사용하여 taxiPassenger의 배열에 추가한다.
        Vehicle taxi = new Vehicle(VehicleType.SEDAN, taxiPassengers);
        // Vehicle에 대입하는 taxi 개체를 선언하고,VehicleType의 enum인 SEDAN에다가 taxiPassenger의 선언한 배열들을 대입.
        taxi.addFuel(60.0); //Vehilce Class의 멤버 변수인 fuelAmount 60을 대입, 개체 addFuel을 링크하여 
        // 그 대입한 값을 개체 taxi에 대입한다.
        
        // 이것이 가능한 이유는 Vehicle 클래스에 다양한 생성자들을 만들어 놨기 때문

        ArrayList<Passenger> vanPassengers = new ArrayList<Passenger>(); 
        // 새로운 ArryList의 배열을 생성하여 vanPassenger라는 개체 선언
        vanPassengers.add(new Passenger("Steve")); 
        //steve라는 값을 가진 배열을 생성하여 Passenger 클래스의 name 맴버 문자열(String) 변수에 대입하고 vanPassenger 개체에도 대입
        vanPassengers.add(new Passenger("Bucky"));
        //Bucky라는 값을 가진 배열을 생성하여 Passenger 클래스의 name 맴버 문자열(String) 변수에 대입하고 vanPassenger 개체에도 대입
        vanPassengers.add(new Passenger("Wanda"));
        //Wanda라는 값을 가진 배열을 생성하여 Passenger 클래스의 name 맴버 문자열(String) 변수에 대입하고 vanPassenger 개체에도 대입
        vanPassengers.add(new Passenger("Bruce"));
        //Bruce라는 값을 가진 배열을 생성하여 Passenger 클래스의 name 맴버 문자열(String) 변수에 대입하고 vanPassenger 개체에도 대입
        vanPassengers.add(new Passenger("Clint"));
        //Clint라는 값을 가진 배열을 생성하여 Passenger 클래스의 name 맴버 문자열(String) 변수에 대입하고 vanPassenger 개체에도 대입
        
        // 승합차에 태울 승객은 어벤져스 전부!
        
        Vehicle van = new Vehicle(VehicleType.MINIVAN, vanPassengers, 70.5);
        // Vehicle에 대입하는 van 개체를 선언하고, VehicleType의 enum인 MINIVAN에다가 taxiPassenger의 선언한 배열들을 대입.
        // 그 와 동시에 Vehicle의 Class 멤버 변수인 fuelAmount에다가 70.5를 대입
        // 승합차에 모두 탑승
        System.out.println("Motorcycle:"); // 출력문
        motorcycle.drive(50);
        // Vehicle의 Class에 속하는 motocycle을 선언하였으며
        // 그 선언한 motocycle을 참조하여 Vegicle Class의 개체인 dirve에 값에 50을 대입하였다.
        //오토바이가 50km를 이동하고, 남은 연료는 19.49L. 주행거리계에 표시되는 숫자는 50km

        System.out.println("Taxi:"); // 출력문
        taxi.drive(50);
        //// Vehicle의 Class에 속하는 taxi를 선언하였으며
        // 그 선언한 taxi을 참조하여 Vegicle Class의 개체인 drive와 동시에 선언한 int형 변수 distance에다가 50을 대입
        //댁시가 50km를 이동하고, 남은 연료는 56.48L. 주행거리계에 표시되는 숫자는 50km

        System.out.println("Van:");
        van.drive(50);
        // Vehicle의 Class에 속하는 van을 선언하였으며
        // 그 선언한 van을 참조하여 Vegicle Class의 개체인 drive와 동시에 선언한 int형 변수 distance에다가 50을 대입
        //승합차가 50km를 이동하고, 남은 연료는 65.45L. 주행거리계에 표시되는 숫자는 50km

        // 세 차량은 모두 50Km를 이동
        // drive() 메서드 호출 시 출력되는 내용이 각 차량마다 다르다는 점에 주목
        // 각 Vehicle 개체가 자신만의 데이터를 가지기 때문임. 각 개체가 가지는 데이터는 다른 개체로부터 분리되어 있다
        // 따라서 오토바이 개체의 drive() 메서드를 호출하는 것은 택시나 승합차에 전혀 영향을 안 미침
        
        van.removePassenger("Steve");
        //Vehicle의 Class에 속하는 van을 선언하였으며
        // Vehicle Class의 개체 removePassenger을 참조해서 steve라는 값을 가진 배열을 삭제
        van.removePassenger("Bucky");
        //Vehicle의 Class에 속하는 van을 선언하였으며
        // Vehicle Class의 개체 removePassenger을 참조해서 Bucky라는 값을 가진 배열을 삭제
        // 스티브와 버키를 하차
        System.out.println("Van:"); //출력문
        van.drive(1000);
        //Vehicle의 Class에 속하는 van을 선언하였으며
        //그 선언한 van을 참조하여 Vegicle Class의 개체인 drive와 동시에 선언한 int형 변수 distance에다가 1000을 대입
        //1000km 이동, 인료가 부족함

        System.out.println("Van:"); //출력문
        van.addFuel(50.0);
        //개체 addFuel와 개체 fuelAmount에서 60을 대입하고 그 대입한 값을 van에 대입한다.
        // 승합차에 50L 주유
        van.drive(100);
        //그 선언한 van을 참조하여 Vegicle Class의 멤버 함수인 drive와 동시에 선언한 int형 개체 distance에다가 1000을 대입
        //100km 이동
    }   // 승합차가 100km를 이동하고, 남은 연료는 105.42L.주행거리계에 표시되는 숫자가 150km가 되었음
}
