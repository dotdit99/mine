package 자동차만들기2;

public class SportsCar extends Car implements Audio {
    public SportsCar(String name) {
        this.speed = 250;       // 속도 km / h
        this.originalSpeed = 250;
        this.fuelEffi = 8.0;    // 연비 km / L
        this.originalFuelEffi = 8.0; // 오리지널 연비
        this.fuelTank = 30;     // 연료탱크 L
        this.seats = 2;         // 좌석 수
        this.name = name;       // 이름
        this.isOn = false;      // 부가기능 ON / OFF
    }

    // SportsCar 부가기능 : turbo - speed 20% 증가
    @Override
    public void setMode(boolean isOn) {
        if (isOn) {
            speed *= 1.2;    // speed(250) * 1.2
        } else {
            speed = 250;
        }
    }

    @Override
    public void audioOn() {
        audioStatus = "ON";
    }

    @Override
    public void audioOff() {
        audioStatus = "OFF";
    }
}
