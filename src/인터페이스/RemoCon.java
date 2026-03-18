package 인터페이스;

// 인터페이스: 클래스가 구현 해야 할 메서드들의 설계 명세서 입니다.
// - "이런 기능을 제공해야 한다"는 규칙 또는 약속을 정의 (강제성)
// - 이를 통해서 다양한 클래스가 동일한 기능을 일관된 형식으로 구현 
// - 기본적으로 모든 메서드가 추상 메서드임 (예외 사항이 있음)
// - 모든 필드는 상수로 변경(public static final 이 자동 추가 됨)
// - 다중 구현 가능 (여러개의 implements 가능)

// 디폴트 메서드: 인터페이스에 있는 구현 메서드를 의미

public interface RemoCon {
    int MAX_VOLUME = 100; // 자동으로 public static final이 붙음, 상속 안됨
    int MIN_VOLUME = 0;
    void turnON(); // 추상 메서드, 자동으로 public abstract가 붙음
    void turnOFF();

    void setVolume(int volume);

    default void setMute(boolean mute){
        if (mute) System.out.println("무음 처리 합니다.");
        else System.out.println("무음 해제 합니다.");
    }

    static void changeBattery(){
        System.out.println("건전지를 교환 합니다.");
    }
}
