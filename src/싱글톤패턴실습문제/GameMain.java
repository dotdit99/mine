package 싱글톤패턴실습문제;

public class GameMain {
    public static void main(String[] args) {

        // =============================================
        // 📌 두 명의 플레이어 생성
        //    Player 생성자 내부에서 자동으로
        //    GameSettings.getGameSettings() 호출
        //    → 두 플레이어 모두 같은 설정 객체를 바라봄
        // =============================================
        Player player1 = new Player("플레이어1");
        Player player2 = new Player("플레이어2");

        // =============================================
        // 📌 초기 설정 확인
        //    두 플레이어 모두 같은 초기값 출력
        //    해상도: 1920x1080 / 볼륨: 50 / 난이도: normal
        // =============================================
        player1.checkSettings();
        player2.checkSettings();

        // =============================================
        // 📌 플레이어1이 설정 변경
        //    싱글톤 객체의 값을 직접 바꾸는 것이므로
        //    모든 플레이어에게 즉시 반영됨
        // =============================================
        System.out.println("\n--- 플레이어1이 설정 변경 ---");
        player1.changeVolume(80);              // 볼륨: 50 → 80
        player1.changeDifficulty("hard");      // 난이도: normal → hard
        player1.changeResolution("2560x1440"); // 해상도: 1920x1080 → 2560x1440

        // =============================================
        // 📌 플레이어2의 설정 확인
        //    player2는 설정을 바꾼 적이 없지만
        //    같은 싱글톤 객체를 바라보기 때문에
        //    player1이 바꾼 값이 그대로 보임 ✅
        // =============================================
        System.out.println("\n--- 플레이어2의 설정 확인 ---");
        player2.checkSettings();

        // =============================================
        // 📌 같은 인스턴스인지 검증
        //    getGameSettings()를 두 번 호출해도
        //    항상 동일한 객체를 반환
        //    == 는 같은 객체인지(주소값) 비교
        // =============================================
        System.out.println("\n--- 같은 인스턴스인가? ---");
        GameSettings s1 = GameSettings.getGameSettings();
        GameSettings s2 = GameSettings.getGameSettings();
        System.out.println(s1 == s2); // true ✅ 주소값이 같음
    }
}