package 알피지게임;
// ============================================================
//  Dungeon.java — 던전 흐름 관리 (5개 층)
// ============================================================
import java.util.Scanner;

public class Dungeon {

    private final Hero         hero;
    private final BattleSystem battle;
    private final Shop         shop;
    private final Scanner      scanner;
    private       int          currentFloor;

    public Dungeon(Hero hero, Scanner scanner) {
        this.hero         = hero;
        this.scanner      = scanner;
        this.battle       = new BattleSystem(scanner);
        this.shop         = new Shop(scanner);
        this.currentFloor = 1;
    }

    // ── 던전 전체 진행 ────────────────────────────────────────
    public void start() {
        System.out.println();
        System.out.println("  📜 [던전 입구]");
        System.out.println("  전설에 따르면 5층 깊숙이 마왕 다크로스가 잠들어 있다.");
        System.out.println("  용감한 " + hero.getName() + "이(가) 던전에 발을 내딛었다...");
        GameUI.pause(1200);

        for (currentFloor = 1; currentFloor <= 5; currentFloor++) {
            if (!runFloor(currentFloor)) {
                gameOver();
                return;
            }
            if (currentFloor < 5) {
                floorClear(currentFloor);
                shopOrContinue();
            }
        }
        ending();
    }

    // ── 각 층 실행 ────────────────────────────────────────────
    private boolean runFloor(int floor) {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.printf ("║  🏰 던전 %d층  %s%n", floor, floorTheme(floor));
        System.out.println("╚════════════════════════════════════════╝");
        GameUI.pause(600);

        Monster[] monsters = switch (floor) {
            case 1 -> Monster.floor1Monsters();
            case 2 -> Monster.floor2Monsters();
            case 3 -> Monster.floor3Monsters();
            case 4 -> Monster.floor4Monsters();
            case 5 -> Monster.floor5Monsters();
            default -> new Monster[]{};
        };

        for (Monster monster : monsters) {
            // 전투 전 상황 연출
            System.out.println();
            System.out.printf("  👀 %s %s 등장!%n", monster.getEmoji(), monster.getName());
            GameUI.pause(500);

            System.out.println("  싸울 준비가 되었나요?");
            System.out.println("   1. ⚔️  전투 시작");
            System.out.println("   2. 📋  현재 상태 확인");

            int choice = GameUI.getIntInput(scanner, "  선택 > ", 1, 2);
            if (choice == 2) {
                hero.printStatus();
                System.out.println("  ⌨️  Enter를 눌러 전투를 시작하세요...");
                scanner.nextLine();
            }

            if (!battle.fight(hero, monster)) {
                return false; // 패배
            }
            GameUI.pause(500);
        }
        return true;
    }

    // ── 층 클리어 처리 ────────────────────────────────────────
    private void floorClear(int floor) {
        System.out.println();
        System.out.println("  🎊 " + floor + "층 클리어!");
        System.out.println("  체력과 MP가 50% 회복되었습니다.");
        hero.heal((int)(hero.getMaxHp() * 0.5));
        // MP 회복
        System.out.println();
        hero.printStatus();
        GameUI.pause(800);
    }

    // ── 상점 or 바로 진행 ─────────────────────────────────────
    private void shopOrContinue() {
        System.out.println();
        System.out.println("  계단이 보인다. 다음 층으로 내려가기 전에...");
        System.out.println("   1. 🏪  상점 방문");
        System.out.println("   2. ⬇️   바로 다음 층으로");

        int choice = GameUI.getIntInput(scanner, "  선택 > ", 1, 2);
        if (choice == 1) shop.open(hero);
    }

    // ── 층별 테마 이름 ────────────────────────────────────────
    private String floorTheme(int floor) {
        return switch (floor) {
            case 1 -> "— 어둠의 입구";
            case 2 -> "— 오크 요새";
            case 3 -> "— 저주받은 묘지";
            case 4 -> "— 흡혈귀의 성";
            case 5 -> "— 마왕의 방  ★";
            default -> "";
        };
    }

    // ── 게임 오버 ─────────────────────────────────────────────
    private void gameOver() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║           💀  GAME  OVER  💀           ║");
        System.out.println("║                                        ║");
        System.out.printf ("║  %s이(가) %d층에서 쓰러졌다...%n", hero.getName(), currentFloor);
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        hero.printStatus();
    }

    // ── 엔딩 ─────────────────────────────────────────────────
    private void ending() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║  🏆  마왕을 물리쳤다!  GAME CLEAR!  🏆  ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  " + hero.getName() + "의 용맹으로 세계는 구원받았다.");
        System.out.println();
        hero.printStatus();
        System.out.println();
        System.out.printf("  🏅 최종 레벨: Lv.%d%n",  hero.getLevel());
        System.out.printf("  💰 획득 골드: %dG%n",    hero.getGold());
        System.out.println();
        System.out.println("  ありがとう！감사합니다！");
    }
}
