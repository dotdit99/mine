package 자동차만들기2;

public class Bus extends Car implements AutoPilot {
    public Bus(String name) {
        this.speed = 150;       // 속도 km / h
        this.originalSpeed = 150;
        this.fuelEffi = 5.0;    // 연비 km / L
        this.originalFuelEffi = 5.0; // 오리지널 연비
        this.fuelTank = 100;    // 연료탱크 L
        this.seats = 20;        // 좌석 수
        this.name = name;       // 이름
        this.isOn = false;      // 부가기능 ON / OFF
    }

    // Bus 부가기능 : 연료탱크 30L 추가
    @Override
    public void setMode(boolean isOn) {
        if (isOn) {
            fuelTank = 130; // fuelTank(100) + 30
        } else {
            fuelTank = 100;
        }
    }

    @Override
    public void autoPilotOn() {
        this.speed *= 0.9;
    }

    @Override
    public void autoPilotOff() {
        this.speed = originalSpeed;
    }
}
