package 자동차만들기2;

public abstract class Car implements Aircon {
    protected int speed;            // 속도
    protected double fuelEffi;      // 주유 횟수
    protected int fuelTank;         // 연료탱크 크기
    protected int seats;            // 좌석 수
    protected String name;          // 이름
    protected boolean isOn;         // 부가기능
    protected double originalFuelEffi;
    protected int originalSpeed;
    protected String audioStatus = "OFF";
    // 이동 횟수 = 승객 수 / 좌석 수
    public int moves(int passengerCount) {
         return (int) Math.ceil((double)passengerCount / seats);
    }
    // 주유 횟수 = 총 연료 소모량 / 연료 탱크 크기
    //          총 연료 소모량 = 총 이동거리 / 연비
    public int refueling(int totalDistance) {
         return (int)(Math.ceil((totalDistance / fuelEffi) / fuelTank));
    }
    // 총 비용 = 총 이동거리 / 연비 * 2,000원
    public int totalCost(int totalDistance) {
         return (int)(totalDistance / fuelEffi * 2000);
    }
    // 이동 시간 = 거리 / 속도 * 이동횟수 * 날씨 보정 계수 (※ 결과는 Hour단위)
    public double totalTime(int distance, int passengerCount, double weather) {
        return (double)distance / speed * moves(passengerCount) * weather;
    }
    // 부가기능 설정 여부
    public abstract void setMode(boolean isOn);

    @Override
    public double getFuelEffi(){
        return this.fuelEffi;
    }
    @Override
    public void setFuelEffi(double fuelEffi) {
        this.fuelEffi = fuelEffi;
    }

    @Override
    public void airconON() {
        this.fuelEffi *= 0.95;
    }
    @Override
    public void airconOFF(){
        this.fuelEffi = originalFuelEffi;
    }

}
