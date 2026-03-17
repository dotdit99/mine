package 싱글톤;

// 싱글톤(SingleTon): 단 하나의 객체만 생성하는 기법, 메모리 절약과 정보 공유를 위해서 사용

public class SingleTonMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setInfo("안유진", 23);
        student2.printInfo();
    }
}
