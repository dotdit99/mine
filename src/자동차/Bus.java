package 자동차;

//- 연비: 5km/L
//- 속도: 150km/h
//- 연료탱크: 100L
//- 좌석: 20
//- 이름: 생성자 입력
//- 부가기능:
//    보조 연료탱크 (30L 추가)

public class Bus extends Car {
    public Bus (String name){
        this.name = name;
        this.fuelEffi = 5;
        this.speed = 150;
        this.seats = 20;
        this.fuelTank = 100;

    }
    public void setMode(boolean isOn){
        if (isOn){
            this.fuelTank += 30;
            System.out.println("보조 연료탱크 장착 (30L 추가)");
        }else {
            this.fuelTank = 100;
            System.out.println("보조 연료탱크 장착 해제");
        }
    }
}
