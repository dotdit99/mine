package 스레드협업;

public class ThreadMain {
    public static void main(String[] args) {
        WorkObject workObject = new WorkObject();
        ThreadA threadA = new ThreadA(workObject);
        ThreadB threadB = new ThreadB(workObject);

        threadA.start(); // ✅ 스레드 시작
        threadB.start(); // ✅ 스레드 시작
    }
}

class WorkObject {
    public synchronized void methodA() {
        System.out.println("ThreadA의 methodA() 작업 실행");
        notify(); // ✅ 일시 정지된 다른 스레드(B)를 실행 대기 상태로
        try {
            wait(); // ✅ 자신(A)은 대기 상태로
        } catch (InterruptedException e) {
            System.out.println("인터럽트 예외 발생");
        }
    }

    public synchronized void methodB() { // ✅ 내용 추가
        System.out.println("ThreadB의 methodB() 작업 실행");
        notify(); // ✅ 일시 정지된 다른 스레드(A)를 실행 대기 상태로
        try {
            wait(); // ✅ 자신(B)은 대기 상태로
        } catch (InterruptedException e) {
            System.out.println("인터럽트 예외 발생");
        }
    }
}

class ThreadA extends Thread {
    private final WorkObject workObject;

    public ThreadA(WorkObject workObject) { // ✅ ThreadA 생성자만 존재
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            workObject.methodA();
        }
    }
}

class ThreadB extends Thread { // ✅ ThreadB 클래스 별도 정의
    private final WorkObject workObject;

    public ThreadB(WorkObject workObject) {
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            workObject.methodB();
        }
    }
}