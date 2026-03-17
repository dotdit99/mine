package 인터페이스;

import java.util.Scanner;

public class InterfaceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("리모컨으로 동작할 제품 선택 [1]TV [2]PS5 : ");
        int menu = sc.nextInt();
        RemoCon rc = null;
        if(menu == 1){
           rc = new Television();
           rc.turnON();
           rc.setVolume(30);
           Television tv = (Television) rc; // 다운캐스팅
           tv.setChannel(100);
        }else {
        rc = new PlayStation5();
        rc.turnON();
        rc.setVolume(50);
        PlayStation5 ps5 = (PlayStation5) rc;
        ps5.playGame("FIFA");
        }
    }
}

