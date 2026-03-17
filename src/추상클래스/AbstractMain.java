package 추상클래스;

// 추상클래스
// 1. 객체를 만들 수 없는 클래스
// 추상 메서드 (Abstract Method)
// 이름만 있고 몸통({ })이 없는 미완성 메서드
// 2. 일반 메서드와 추상 메서드가 함께 있을 수 있음
// 3. 공통 기능을 묶어 제공하고, 자식 클래스가 반드시 구해ㅕㄴ해야 할 메서드를 강제할 때 사용
public class AbstractMain {
    public static void main(String[] args) {
        AndroidPhone phone = new AndroidPhone("Samsung", true);
        phone.call();
        phone.setMode(true);

        ApplePhone applePhone = new ApplePhone("iPhone", false);
        applePhone.call();
        applePhone.setMode(true);
    }
}
