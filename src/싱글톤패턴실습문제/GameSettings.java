package 싱글톤패턴실습문제;

// 사용하지 않는 import → 삭제해도 됩니다
// import 싱글톤.SingleTon;
// import java.util.Stack;

public class GameSettings {

    // =============================================
    // 📌 필드 (속성) - 게임 설정값 저장
    // =============================================
    private String resolution;   // 해상도
    private int volume;          // 볼륨
    private String difficulty;   // 난이도

    // =============================================
    // 📌 싱글톤 핵심 - 인스턴스를 딱 하나만 생성
    //    static : 클래스가 로딩될 때 딱 한 번만 실행
    //    private : 외부에서 이 변수에 직접 접근 불가
    // =============================================
    private static GameSettings gameSettings = new GameSettings();

    // =============================================
    // 📌 생성자 - private으로 외부에서 new 사용 차단
    //    외부에서 new GameSettings() 하면 에러 발생
    //    오직 위의 static 필드에서만 딱 한 번 호출됨
    // =============================================
    private GameSettings() {
        resolution = "1920x1080";  // ⚠️ 기존 코드 오타: 10800 → 1080
        volume = 50;
        difficulty = "normal";
    }

    // =============================================
    // 📌 외부에서 인스턴스를 가져가는 유일한 통로
    //    static : 객체 없이 클래스명으로 바로 호출 가능
    //    예) GameSettings.getGameSettings()
    // =============================================
    public static GameSettings getGameSettings() {
        return gameSettings;
    }

    // =============================================
    // 📌 Getter / Setter
    //    private 필드는 외부에서 직접 접근 불가
    //    → Getter로 읽고, Setter로 변경
    // =============================================

    // 해상도 읽기
    public String getResolution() {
        return resolution;
    }

    // 해상도 변경
    public void setResolution(String resolution) {
        this.resolution = resolution; // this.resolution = 필드 / resolution = 매개변수
    }

    // 볼륨 읽기
    public int getVolume() {
        return volume;
    }

    // 볼륨 변경
    public void setVolume(int volume) {
        this.volume = volume;
    }

    // 난이도 읽기
    public String getDifficulty() {
        return difficulty;
    }

    // 난이도 변경
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    // =============================================
    // 📌 현재 설정값을 한 번에 출력하는 메서드
    // =============================================
    public void printSettings() {
        System.out.println("=== 현재 게임 설정 ===");
        System.out.println("해상도: " + resolution);
        System.out.println("볼륨: "   + volume);
        System.out.println("난이도: " + difficulty);
    }
}
