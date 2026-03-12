package 상속TV;

import java.util.Scanner;

import static java.lang.System.exit;

public class TVMain extends ProductTV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TV 메뉴 만들기
        ProductTV tv = new ProductTV(false, 11, 10, "LG TV");
        while (true) {
            System.out.println("1. 전원 켜기");
            System.out.println("2. 볼륨 조절");
            System.out.println("3. 채널 변경");
            System.out.println("4. 현재 TV 상태값 보기");
            System.out.println("5. 종료 하기");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("TV 전원을 켜시겠습니까 (yes / no) : ");
                    String power = sc.nextLine();
                    if (power.equals("yes")) tv.setPower(true);
                    else tv.setPower(false);
                    break;
                case 2:
                    System.out.print("볼륨값 입력 : ");
                    int volume = sc.nextInt();
                    tv.setVolume(volume);
                    break;
                case 3:
                    System.out.print("스마트 모드 켜기 (ON/OFF) : ");
                    String smart = sc. next();
                    if (smart.equals("ON")){
                        tv.setChannel(0, true);
                    }else {
                        System.out.print("채널 값 입력: ");
                        int channel = sc.nextInt();
                        tv.setChannel(channel);
                    }

                    System.out.print("채널값 입력 : ");
                    int channel = sc.nextInt();
                    tv.setChannel(channel);
                    break;
                case 4:
                    tv.printTV();
                    break;
                case 5:
                    System.out.println("TV를 종료합니다.");
                    tv.setPower(false);
                    return;
                default:
                    System.out.println("메뉴 선택이 잘못 되었습니다.");



            }
            // 1. TV 켜기
            // 2. Volume 설정 하기
            // 3. 채널 변경 시 Smart 기능을 켜면 채널 설정은 없음
            //    Smart 기능을 끄면 채널 설정 기능 활성화
        }
    }
}

