package 스레드안전종료;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("[1]스레드 종료 [2]스레드 계속 : ");
            int menu = sc.nextInt();
            if (menu == 1) {
                // threadTest.setStop(true);  // stop 플래그 방식
                threadTest.interrupt();        // interrupt 방식
                break;
            }
        }
    }
}

class ThreadTest extends Thread {
    private volatile boolean stop = false;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        int cnt = 0;
        while (!Thread.currentThread().isInterrupted()) {
            cnt++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break; // sleep 중 interrupt 신호 오면 반복문 탈출
            }
        }
        System.out.printf("[%d]\n", cnt);
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}