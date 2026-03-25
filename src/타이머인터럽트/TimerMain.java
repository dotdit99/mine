package 타이머인터럽트;

public class TimerMain {
    public static void main(String[] args) throws InterruptedException {
        TimerThread thread = new TimerThread();
        thread.start(); // 스레드 실행 대기 상태

        Thread.sleep(5000); // 5초 대기
        thread.interrupt(); // 작업 중단
    }
}

class TimerThread extends Thread{
    @Override
    public void run() {
        System.out.println("작업 시작");

        for(int i = 0; i < 10; i++) {
            System.out.println("작업 진행: " + i);
            try {
                Thread.sleep(1000);
            }catch ( InterruptedException e){
                System.out.println("작업이 인터럽트로 인해 중단 됨");
                return;
            }
        }

        System.out.println("");
    }
}