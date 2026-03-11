package 에어컨만들기;

// 기능 설계
// 전원 ON/OFF 기능
// 온도 설정 기능 (1도 단위 설정)
// 현재 온도 표시 기능
// 냉방기 ON/OFF 기능
// 난방기 ON/OFF 기능
// 바람 세기 설정 (1단계 / 2단계 / 3단계)

// 생성자 만들기
// 각각의 필드에 대한 게터와 세터 만들기
// 에어컨의 전체 정보 상태를 보여주는 메서드 만들기

public class AirCon {
    boolean power; // 전원
    int tempSet; // 온도 설정
    int tempNow; // 현재 온도 표시
    boolean cooler; // ON/OFF
    boolean heater; // ON/OFF
    int wind; // 바람 단계 1/ 2 / 3
    String step[] = new String[]{"1단계", "2단계", "3단계"};

    public AirCon(){
        power = false;
        tempSet = 20; // 설정 온도
        tempNow = 20; // 현재 온도
        cooler = false;
        heater = false;
        wind = 1;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public boolean isHeater() {
        return heater;
    }

    public void setHeater(boolean heater) {
        this.heater = heater;
    }

    public boolean isCooler() {
        return cooler;
    }

    public void setCooler(boolean cooler) {
        this.cooler = cooler;
    }

    public int getTempNow() {
        return tempNow;
    }

    public void setTempNow(int tempNow) {
        this.tempNow = tempNow;
    }

    public int getTempSet() {
        return tempSet;
    }

    public void setTempSet(int tempSet) {
        this.tempSet = tempSet;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public void printAirCon(){
        System.out.println("===== 에어컨 정보 =====");
        System.out.println("전원 " + (power ? "ON" : "OFF"));
        System.out.println("현재 온도: " + getTempNow());
        System.out.println("설정 온도: " + getTempSet());
        System.out.println("냉방 모드: " + (cooler ? "ON" : "OFF"));
        System.out.println("난방 모드: " + (heater ? "ON" : "OFF"));
        System.out.println("바람 세기: " + step[wind - 1]);
    }
}