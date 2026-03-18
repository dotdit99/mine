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

        RemoCon audio = new RemoCon() {
            private int volume = 0;
            @Override
            public void turnON() {
                System.out.println("오디오 전원을 켭니다.");
            }

            @Override
            public void turnOFF() {
                System.out.println("오디오 전원을 끕니다.");
            }

            @Override
            public void setVolume(int volume) {
                if (volume > RemoCon.MAX_VOLUME){
                    this.volume = RemoCon.MAX_VOLUME;
                }else if (volume < RemoCon.MIN_VOLUME){
                    this.volume = RemoCon.MIN_VOLUME;
                }else {
                    this.volume = volume;
                }
                System.out.println("현재 오디오 볼륨은 " + this.volume);
            }
        };
        audio.turnON();
        audio.setVolume(50);
    }
}

