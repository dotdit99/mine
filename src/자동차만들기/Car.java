package 자동차만들기;

import 자동차만들기2.Aircon;

import java.text.DecimalFormat;

import static 자동차만들기.Common.FUEL_PRICE;

public abstract class Car {
    protected int maxSpeed; // 최고 속도
    protected int fuelEff; // 연비 (리터당 주행 거리(Km))
    protected int fuelTank; // 연료 탱크 크기
    protected int seatCnt; // 좌석수
    protected String name; // 자동차 이름

    // 매개변수가 있는 생성자, 기본생성자는 없음
    public Car(int maxSpeed, int fuelEff, int fuelTank, int seatCnt, String name) {
        this.maxSpeed = maxSpeed;
        this.fuelEff = fuelEff;
        this.fuelTank = fuelTank;
        this.seatCnt = seatCnt;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    // 총 이동 횟수
    int getMovingCnt(int passCnt) {
        return (int) Math.ceil((double) passCnt / seatCnt);
    }

    // 총 주유 횟수
    int getRefuelCnt(int dist, int moveCnt) { // 이동 거리와 이동 횟수를 매개 변수로 전달 받음
        double totalDistance = dist * moveCnt;
        double totalFuel = totalDistance / fuelEff;  // 거리 / 연비
        return (int) Math.ceil(totalFuel / fuelTank); // 연료소모량 / 연료통 크기
    }

    // 총 이동 비용
    String getTotalCost(int dist, int moveCnt) {
        double totalDistance = dist * moveCnt;
        double totalFuel = totalDistance / fuelEff;
        long totalCost = Math.round(totalFuel * FUEL_PRICE);
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(totalCost);
    }

    // 총 소요 시간
    String getMovingTime(int dist, int moveCnt, int weather) {
        double getTime = (double) dist * moveCnt / maxSpeed;

        switch (weather) {
            case 2: getTime *= 1.2; break;
            case 3: getTime *= 1.4; break;
            default:
        }

        int totalMinute = (int) (getTime * 60);
        int hour = totalMinute / 60;
        int minute = totalMinute % 60;
        return String.format("%d시간 %d분", hour, minute);
    }

    abstract void setMode(boolean isMode); // 상속 받은 각각의 자동차의 특수 기능

}
