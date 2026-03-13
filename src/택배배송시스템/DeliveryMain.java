package 택배배송시스템;

import java.util.Scanner;

public class DeliveryMain {
    public static void main(String[] args) {
        Manager manager = new Manager("홍길동");
        Scanner sc = new Scanner(System.in);
        System.out.print("[1] 택배 배송 [2] 퀵 배송 [3] 항공 배송: ");
        int menu = sc.nextInt();
        switch (menu){
            case 1: manager.send(new ParcelDelivery("대한통운")); break;
            case 2: manager.send(new QuickDelivery("쿠팡 로켓 배송"));break;
            case 3: manager.send(new AirDelivery("FedEX"));break;
            default: System.out.println("배송 시스템을 잘못 선택 하셨습니다.");
        }
    }
}
