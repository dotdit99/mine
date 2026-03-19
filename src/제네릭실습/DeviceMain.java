package 제네릭실습;

import java.util.Scanner;

public class DeviceMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("기기 선택 [1] 프린터 [2] 모니터 [3] 키보드: ");
        int type = sc.nextInt();
        System.out.println("선택: " + type);
        DeviceController<Device> dc = new DeviceController<>();
        Device device = null;

        switch (type) {
            case 1:
                device = new Printer();
                break;
            case 2:
                device = new Monitor();
                break;
            case 3:
                device = new KeyBoard();
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                sc.close();
                return;
        }

        dc.setDevice(device);
        dc.powerOn();
        dc.powerOff();

        sc.close();
    }
}
