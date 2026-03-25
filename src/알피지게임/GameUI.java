package 알피지게임;
// ============================================================
//  GameUI.java — 공통 UI 유틸리티
// ============================================================
import java.util.Scanner;

public class GameUI {

    // 정수 입력 (범위 검증 포함)
    public static int getIntInput(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v >= min && v <= max) return v;
                System.out.println("  ⚠️  " + min + " ~ " + max + " 사이 숫자를 입력하세요.");
            } catch (NumberFormatException e) {
                System.out.println("  ⚠️  숫자를 입력하세요.");
            }
        }
    }

    // 문자열 입력
    public static String getStringInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        return input.isEmpty() ? "영웅" : input;
    }

    // 딜레이
    public static void pause(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    // 타이틀 배너
    public static void printTitle() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║    ⚔️  JAVA DUNGEON RPG  ⚔️             ║");
        System.out.println("║         마왕을 물리쳐라!                ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();
    }

    // 구분선
    public static void divider() {
        System.out.println("────────────────────────────────────────");
    }
}
