package 자동차;

//- 연비: 12km/L
//- 속도: 200km/h
//- 연료탱크: 45L
//- 좌석: 4
//- 이름: 생성자 입력
//- 부가기능:
//    - 트렁크 좌석화 (좌석 1석 추가)

public class Sedan extends Car {
    public Sedan (String name){
        this.name = name;
        this.fuelEffi = 12;
        this.speed = 200;
        this.seats = 4;
        this.fuelTank = 45;

    }
    public void setMode(boolean isOn){
        if (isOn){
            this.seats += 1;
            System.out.println("트렁크 좌석화 좌석 1석 추가");
        }else {
            this.seats = 4;
            System.out.println("트렁크 좌석화 해제");
        }
    }
}
