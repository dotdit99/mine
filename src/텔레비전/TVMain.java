package 텔레비전;

import java.util.Scanner;
import static java.lang.System.exit;

public class TVMain {
    public static void main(String[] args) {
        // Television 클래스로 TV 객체 5개 생성
        Television tv1 = new Television();
        Television tv2 = new Television();
        Television tv3 = new Television();
        Television tv4 = new Television();
        Television tv5 = new Television();
        Scanner sc = new Scanner(System.in);
        // 메뉴 만들기: 생성된 객체 중 아무거나 1개 객체 생성
        // 1. 전원 켜기
        // 2. 볼륨 조절
        // 3. 채널 변경
        // 4. 현재 리모콘 상태값 보기
        // 5. 종료 하기
        while (true) {
            System.out.println("1. 전원 켜기");
            System.out.println("2. 볼륨 조절");
            System.out.println("3. 채널 변경");
            System.out.println("4. 현재 TV 상태값 보기");
            System.out.println("5. 종료 하기");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    tv1.setPower(true);
                    break;
                case 2:
                    System.out.print("볼륨값 입력 : ");
                    int volume = sc.nextInt();
                    tv1.setVolume(volume);
                    break;
                case 3:
                    System.out.print("채널값 입력 : ");
                    int channel = sc.nextInt();
                    tv1.setChannel(channel);
                    break;
                case 4:
                    tv1.printTV();
                    break;
                case 5:
                    System.out.println("TV를 종료 합니다.");
                    tv1.setPower(false);
                    exit(0);
                default:
                    System.out.println("메뉴 선택이 잘 못 되었습니다.");
            }
        }
    }
}
