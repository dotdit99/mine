package 자동차;

//- 연비: 8km/L 최대 240km
//- 속도: 250km/h
//- 연료탱크: 30L
//- 좌석: 2
//- 이름: 생성자 입력
//- 부가기능: **터보** (속도 20% 증가)

public class SportsCar extends Car {
    public SportsCar(String name){
        this.name = name;
        this.fuelEffi = 8;
        this.speed = 250;
        this.seats = 2;
        this.fuelTank = 30;

    }
    public void setMode(boolean isOn){
        if (isOn){
            this.speed = (int) (speed * 1.2);
            System.out.println("터보 ON");
        }else {
            this.speed = 250;
            System.out.println("터보 OFF");
        }
    }
}
