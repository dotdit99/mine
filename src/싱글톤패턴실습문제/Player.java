package 싱글톤패턴실습문제;

public class Player {

    // =============================================
    // 📌 필드 (속성)
    // =============================================
    private String name;             // 플레이어 이름
    private GameSettings settings;   // 게임 설정 객체 (싱글톤 참조)

    // =============================================
    // 📌 생성자
    //    플레이어 이름을 받아서 저장하고,
    //    싱글톤 GameSettings 인스턴스를 가져와 연결
    // =============================================
    public Player(String name) {
        this.name = name;
        this.settings = GameSettings.getGameSettings(); // 싱글톤 객체 가져오기
    }

    // =============================================
    // 📌 볼륨 변경 메서드
    //    settings.setVolume() 을 통해
    //    싱글톤 객체의 볼륨값을 변경
    // =============================================
    public void changeVolume(int volume) {
        System.out.println("[" + name + "] 볼륨을 " + volume + "으로 변경");
        // ⚠️ 기존 코드 오타: "난이도를" → "볼륨을"
        settings.setVolume(volume);
    }

    // =============================================
    // 📌 난이도 변경 메서드
    //    settings.setDifficulty() 을 통해
    //    싱글톤 객체의 난이도값을 변경
    // =============================================
    public void changeDifficulty(String difficulty) {
        System.out.println("[" + name + "] 난이도를 " + difficulty + "으로 변경");
        settings.setDifficulty(difficulty);
    }

    // =============================================
    // 📌 해상도 변경 메서드
    //    settings.setResolution() 을 통해
    //    싱글톤 객체의 해상도값을 변경
    // =============================================
    public void changeResolution(String resolution) {
        System.out.println("[" + name + "] 해상도를 " + resolution + "으로 변경");
        // ⚠️ 기존 코드 오타: "난이도를" → "해상도를"
        settings.setResolution(resolution);
    }

    // =============================================
    // 📌 현재 설정 확인 메서드
    //    싱글톤 객체의 printSettings() 호출
    //    → 모든 플레이어가 같은 설정값을 보게 됨
    // =============================================
    public void checkSettings() {
        System.out.println("\n[" + name + "] 이 확인한 설정:");
        settings.printSettings();
    }
}