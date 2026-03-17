package 자동차만들기2;

import java.util.Scanner;

public class CarMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int airconChoice;
        int audioChoice = 0;
        int autoPilotChoice = 0;

        int distance;
        String region;
        double weather = 1.0;

        // 1. 지역 선택
        System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
        int regionchoice = sc.nextInt();

        switch (regionchoice) {
            case 1:
                region = "부산";
                distance = 400;
                break;
            case 2:
                region = "대전";
                distance = 150;
                break;
            case 3:
                region = "강릉";
                distance = 200;
                break;
            case 4:
                region = "광주";
                distance = 300;
                break;
            default:
                System.out.println("지역 입력이 잘못되었습니다.");
                return;
        }

        // 2. 승객 수 입력
        System.out.print("이동할 승객 수 입력 : ");
        int passengerCount = sc.nextInt();

        if (passengerCount < 1 || passengerCount > 100) {
            System.out.println("승객 수는 1명 이상 100명 이하로 입력해야 합니다.");
            return;
        }

        // 3. 차량 선택
        System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
        int name = sc.nextInt();
        Car car;
        switch (name) {
            case 1:
                car = new SportsCar("스포츠카");
                break;
            case 2:
                car = new Sedan("승용차");
                break;
            case 3:
                car = new Bus("고속버스");
                break;
            default:
                System.out.println("차량 입력이 잘못되었습니다.");
                return;
        }

        // 4. 부가기능 선택
        System.out.print("부가 기능 [1]ON [2]OFF : ");
        int modeChoice = sc.nextInt();

        if (modeChoice == 1) {
            car.setMode(true);
        } else if (modeChoice == 2) {
            car.setMode(false);
        } else {
            System.out.println(" 입력이 잘못되었습니다.");
            return;
        }

        // 5. 날씨 선택
        System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
        int weatherchoice = sc.nextInt();

        switch (weatherchoice) {
            case 1:
                weather = 1.0;
                break;
            case 2:
                weather = 1.2;
                break;
            case 3:
                weather = 1.4;
                break;
            default:
                System.out.println("입력이 잘못되었습니다.");
                return;
        }
        // 6. 에어컨 전원 선택
        System.out.print("[1]에어컨 켜기 [2]에어컨 끄기 : ");
        airconChoice = sc.nextInt();
        switch (airconChoice){
            case 1:
                car.airconON();
                break;
            case 2:
                car.airconOFF();
                break;
            default:
                System.out.println("잘못 선택하셨습니다.");
        }
        // 7. 오디오 전원 선택
        if (car instanceof Audio audio) {
            System.out.print("[1]오디오 켜기 [2]오디오 끄기 : ");
            audioChoice = sc.nextInt();
            switch (audioChoice) {
                case 1:
                    audio.audioOn();
                    break;
                case 2:
                    audio.audioOff();
                    break;
                default:
                    System.out.println("입력을 잘못 하셨습니다.");
            }
        }else{
                // Audio를 구현하지 않은 차량 (버스)
                System.out.println("이 차량은 오디오를 지원하지 않습니다.");
            }
        // 8. 오토 파일럿 선택
        if (car instanceof AutoPilot autoPilot){
            System.out.print("[1]오토파일럿 켜기 [2]오토파일럿 끄기 : ");
            autoPilotChoice = sc.nextInt();
            switch (autoPilotChoice){
                case 1 ->
                        autoPilot.autoPilotOn();
                case 2 ->
                        autoPilot.autoPilotOff();
                default ->
                        System.out.println("입력을 잘못 하셨습니다.");
            }
        }else {
            System.out.println("이 차량은 오토파일럿을 지원하지 않습니다.");
        }

        // 총 이동거리, 시간 계산
        int totalDistance = distance * car.moves(passengerCount);
        int time = (int)(car.totalTime(distance, passengerCount, weather) * 60);

        // 출력
        System.out.println();
        System.out.println("========" + car.name + "========");
        System.out.printf("이동 지역\t: %s\n", region);
        System.out.printf("총 비용\t\t: %,d원\n", car.totalCost(totalDistance));
        System.out.printf("총 주유 횟수 : %d회\n", car.refueling(totalDistance));
        System.out.printf("총 이동 시간 : %02d시간 %02d분\n", (time / 60), (time % 60));
        System.out.println("에어컨 : " + (airconChoice == 1 ? "ON" : "OFF"));
        if (car instanceof Audio) {
            System.out.println("오디오 : " + (audioChoice == 1 ? "ON" : "OFF"));
        }
        if (car instanceof AutoPilot) {
            System.out.println("오토파일럿 : " + (autoPilotChoice == 1 ? "ON" : "OFF"));
        }



    }
}
