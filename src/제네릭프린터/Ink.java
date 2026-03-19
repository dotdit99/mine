package 제네릭프린터;

public class Ink {
    public void doPrinting(){
        System.out.println("잉크를 재료로 프린팅 합니다.");
    }
    @Override
    public String toString(){
        return "재료는 잉크 입니다.";
    }
}
