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

import java.util.Calendar;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class AirCon {
    private boolean power; // 전원
    private int tempSet; // 온도 설정
    private int tempNow; // 현재 온도 표시
    private boolean cooler; // ON/OFF
    private boolean heater; // ON/OFF
    private int wind; // 바람 단계 1/ 2 / 3
    private String step[] = new String[]{"1단계", "2단계", "3단계"};
    private int battery = 100;

    public AirCon(){
        final int[] monthTempArr = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH); // 현재가 몇월인지 가져옴
        tempNow = monthTempArr[month]; // 현재달의 온도를 현재 온도로 대입 받음
        power = false;
        tempSet = 20; // 설정 온도
        cooler = false;
        heater = false;
        wind = 1;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public int getTempSet() {
        return tempSet;
    }

    public void setTempSet(int tempSet) {
        this.tempSet = tempSet;
    }

    public int getTempNow() {
        return tempNow;
    }

    public boolean isCooler() {
        return cooler;
    }

    public void setCooler(boolean cooler) {
        this.cooler = cooler;
    }

    public boolean isHeater() {
        return heater;
    }

    public void setHeater(boolean heater) {
        this.heater = heater;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public void printAirCon(){
        System.out.println("===== 에어컨 정보 =====");
        System.out.println("전원 " + (isPower() ? "ON" : "OFF"));
        System.out.println("현재 온도: " + getTempNow());
        System.out.println("설정 온도: " + getTempSet());
        System.out.println("냉방 모드: " + (isCooler() ? "ON" : "OFF"));
        System.out.println("난방 모드: " + (isHeater() ? "ON" : "OFF"));
        System.out.println("바람 세기: " + step[wind - 1]);
        System.out.println("배터리 상태: " + battery);
    }

    // 에어컨 동작 메서드
    public void operate() {
        int beforeTemp = tempNow;
        int elapsedTime = 0; // 경과 시간을 계산하기 위한 변수
        boolean changedTemp = false; // 온도를 변경해야 하는 조건
        if (tempNow != beforeTemp) {
            battery--;
        }

        System.out.println("\n===== 에어컨 작동을 시작 합니다. =====");
        printAirCon();

        try{
            while (true){
                sleep(1000); // 1초 잠재움
                elapsedTime++;
                int getTimeThreshold = getTimeFunc(); // 바람세기에 따른 시간값 가져 옴

                if (elapsedTime >= getTimeThreshold){ // 온도를 바꿔야 할 상황
                    changedTemp = true;
                }
                if (changedTemp){ // 온도를 변경해야 할 조건, 1단 60, 2단 30, 3단 20초
                    if (cooler) setTempNow(-1);
                    if (heater) setTempNow(1);
                    printAirCon(); // 현재 에어컨 상태를 출력
                    elapsedTime = 0; // 경과 시간을 초기화
                    changedTemp = false; // 온도 변경 조건을 false로 변경
                }
                if (tempNow == getTempSet()) { // 현재 온도와 설정 온도가 같은 경우
                    System.out.println("\n설정 온도에 도달하여 에어컨 작동을 종료 합니다.");
                    power = false;
                    break;
                }
            }

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    // 에어컨 설정
    public void setAirCons(Scanner sc){ // 스캐너 객체를 전달 받음
        System.out.println("현재 온도는 " + getTempNow() + "도 입니다.");
        System.out.print("온도 설정 : ");
        tempSet = sc.nextInt();

        System.out.print("바람 세기: ");
        wind = sc.nextInt();

        if (getTempNow() > getTempSet()) { // 온도를 내려야 하는 경우
            System.out.println("Cooler가 동작 합니다.");
            cooler = true;
            heater = false;
        }else if(getTempNow() < getTempSet()){
            System.out.println("Heater가 동작 합니다.");
            heater = true;
            cooler = false;
        }else{
            cooler = false;
            heater = false;
        }
    }

    // 현재 온도 변경 메서드
    private void setTempNow(int temp){
        tempNow += temp;
    }

    private int getTimeFunc(){
        switch (wind){
            case 1:
                return 60;
            case 2:
                return 30;
            case 3:
                return 20;
            default:
                return 60;
        }
    }
}