package 스레드기본;

// 멀티스레드: 작업을 병렬로 처리하기 위해서 사용
// ┗ 백엔드에서 여러 사용자의 요청을 수행하기 위햇서 주로 사용 함
// ┗ 스레드를 만드는 방법은 상속과 interface 통해서 하는 방법이 존재 함


public class ThreadMain {
    public static void main(String[] args) {

        // Thread 클래스 상속
        CustomeThread thread1 = new CustomeThread();
        thread1.start();

        // Runnable 인터페이스 구현
        CustomeThread runnablwe = new CustomeThread(); // 인터페이스를 상속 받아 객체 생성
        Thread thread2 = new Thread(runnablwe); // 실제 스레드를 만들기 위해 스레드 객체 생성
        thread2.start();


    }
}

// Thread 클래스 상속으로 구현: 단일 상속만 가능
class CustomeThread extends Thread {

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
            System.out.println(Thread.currentThread() + " : " + sum);
        }
        //System.out.println(Thread.currentThread().getName() + " : " + sum);
    }
}

// Runnable 인터페이스 구현
class CustomRunnable implements Runnable {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
            System.out.println(Thread.currentThread() + " : " + sum);
        }
    }
}