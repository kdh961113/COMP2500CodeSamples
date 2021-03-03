package Vehicle;

import java.util.ArrayList; // List 인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 선형리스트

public class Vehicle { //Vehicle 클래스를 선언
    public VehicleType type; // 맴버 변수 선언
    public ArrayList<Passenger> passengers; //멤버 배열 선언, ArrayList에 대입, 어떤 형의 개체들을 저장할 것인지 지정
    //passengers는 Passenger 개체들의 리스트
    public double fuelAmount; // 멤버  변수 선언
    public int mileage; // 멤버 변수 선언
    
    public Vehicle(VehicleType type) { // 개체를 Vehicle 선언하고 VeicleType으로의 type에 대입
        this(type, new ArrayList<Passenger>(), 0.0);
    }// 생성자. 이렇게 생성자를 만들었으면 이제 기본 생성자를 사용 못함, 즉 0으로 생성자의 fuelAmount 값을 0으로 초기화

    public Vehicle(VehicleType type, ArrayList<Passenger> passengers) {
        //개체 Vehicle를 선언하고 VehicleType의 type와 Array<Passenger>의 passenger에 대입
        this(type, passengers, 0.0);
        //첫 번째 매개변수로 VehicleType, 두번째 매개변수 ArrayList<Passenger>, 세 번째 매개변수 double을 받는 생성자를 호출

    }

    public Vehicle(VehicleType type, double fuelAmount) { // 개체 Vehicle을 선언하고 VehicleType의 type와 fuelAmount에 대입
        this(type, new ArrayList<Passenger>(), fuelAmount);
        //생성자를 선언하고 ArrayList<Passerger>의 새로운 배열 추가, fuelAmount에 대입
    }

    public Vehicle(VehicleType type, ArrayList<Passenger> passengers, double fuelAmount) {
        //개체를 Vehicle 선언하고 VehicleType의 Type, ArrayList<passenger>의 Passenger, fuelAmount에 대입
        this.type = type; //type에 대입하는 생성자 선언
        this.passengers = passengers; //passenger에 대입하는 생성자 선언
        this.fuelAmount = fuelAmount; // fuelAmount에 대입하는 생성자 선언
        this.mileage = 0; 
    } // 생성자 오버로딩, 모든 멤버변수 초기화
    // 다른 생성자에서 이 생성자를 호출하니 다른 생성자 안에서 이 코드를 중복할 필요가 없다.

   public void addPassenger(Passenger passenger) {
        // void 개체 addPassenger를 선언 함. 그리고 Passenger class에 대입하는 passenger 변수를 선언 및 대입함.
        this.passengers.add(passenger);
    } // 현재 Vehicle 개체의 승객 리스트에 passenger를 추가함, add()는 Passenger class에 대입하는  passenger 멈버 변수의 개체이다.

    public void removePassenger(String name) { // void 개체 removePassenger 선언, removePssenger는 name의 배열의 값을 대입한다.
        for (Passenger p : this.passengers) { //foreach 반복문을 이용하여 승객 목록을 모두 훑어보는 for문 선언
            if (p.name.equals(name)) { //문자열을 비교할 때 '=='를 사용하지 말 것! String 클래스의 equals() 개체를 사용해야 함!
                this.passengers.remove(p);
                // 생성자 선언, 해당 이름을 가진 승객을 찾으며 passengers 리스트로부터 제거한다. remove()는 ArrayList의 개체이다.
                break;
            }
        }
    }

    public void addFuel(double fuelAmount) {
        this.fuelAmount += fuelAmount;
    }
    // void 개체 addFeul을 선언, fuelAmount에 fuelAmount를 +=을 사용하여 증가 시킴.

    public void drive(int distance) { // void 개체 drive 선언, 동시에 int형 변수 distance 선언하여 값을 대입
        System.out.println(String.format("Traveling %dkm.", distance)); // 출력

        double gasMileage = 100000; //변수 선언, gasMileage을 100000으로 초기화

        switch (this.type) { //swich문 사용
            case MOTORCYCLE: //Java에서 열거형을 switch/case에 사용 할 때는 그냥 값만을 사용함.
                gasMileage = 0.05;
                break;
            case SEDAN:
                gasMileage = 0.07;
                break;
            case MINIVAN:
                gasMileage = 0.1;
                break;
            default:
                assert (false) : "Unrecognized vehicle type: " + this.type;
                break; //default에서 assert을 선언
        }// 이 switch문을 사용해서 차량의 종류에 따라 현재 차의 gasMileage를 결정

        double requiredFuel = gasMileage * distance + 0.01 * this.passengers.size();
        //  변수 선언, 주어진 거리를 이동하려면 필요한 연료의 양을 계산, 
        if (requiredFuel > this.fuelAmount) { //if문 선언, requiredFuel(필요한 연료)가 fuelAomunt 보다 작다면 실행
            System.out.println("Not enough fuel to travel that far!"); // 출력문
        } else {
            this.fuelAmount -= requiredFuel; // 변수 requiredFule을 증감연산자를 사용해서 생성자 fuelAmount에 대응
            this.mileage += distance;// 주어진 거리만큼 이동 후 fuelAmount와 mileage를 재계산
            System.out.println(String.format("FuelAmount %.2fL.", this.fuelAmount)); // 메시지 출력
            System.out.println(String.format("Mileage %dkm.", this.mileage));   // 메시지 출력
//fuelAmount와 mileage를 출력
        }

    }
}
