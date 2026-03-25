package 알피지게임;
// ============================================================
//  Main.java — 게임 진입점
// ============================================================
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GameUI.printTitle();

        // ── 캐릭터 생성 ───────────────────────────────────────
        System.out.println("  ✏️  영웅의 이름을 입력하세요:");
        String name = GameUI.getStringInput(scanner, "  이름 > ");

        System.out.println();
        System.out.println("  ⚔️  직업을 선택하세요:");
        System.out.println();
        System.out.println("  ┌─────────────────────────────────────────────────┐");
        System.out.println("  │  1. ⚔️  전사  — HP 200 / ATK 40 / DEF 15 / SPD 8  │");
        System.out.println("  │          튼튼한 방어와 강한 일격이 특기            │");
        System.out.println("  │                                                   │");
        System.out.println("  │  2. 🔮 마법사 — HP 130 / ATK 55 / DEF  5 / SPD 12│");
        System.out.println("  │          강력한 마법으로 적을 섬멸                 │");
        System.out.println("  │                                                   │");
        System.out.println("  │  3. 🏹 궁수  — HP 160 / ATK 35 / DEF 10 / SPD 15 │");
        System.out.println("  │          빠른 속도와 높은 치명타가 특기             │");
        System.out.println("  └─────────────────────────────────────────────────┘");

        int jobChoice = GameUI.getIntInput(scanner, "  선택 > ", 1, 3);
        Hero.JobClass jobClass = switch (jobChoice) {
            case 1 -> Hero.JobClass.WARRIOR;
            case 2 -> Hero.JobClass.MAGE;
            case 3 -> Hero.JobClass.ARCHER;
            default -> Hero.JobClass.WARRIOR;
        };

        Hero hero = new Hero(name, jobClass);

        System.out.println();
        System.out.println("  🎮 캐릭터 생성 완료!");
        hero.printStatus();
        System.out.println();
        System.out.println("  스킬 목록:");
        for (Skill s : hero.getSkills()) {
            System.out.printf("    %s %s — %s (MP: %d)%n",
                    s.getEmoji(), s.getName(), s.getDescription(), s.getMpCost());
        }

        System.out.println();
        System.out.println("  ⌨️  Enter를 눌러 던전에 입장하세요...");
        scanner.nextLine();

        // ── 던전 시작 ─────────────────────────────────────────
        Dungeon dungeon = new Dungeon(hero, scanner);
        dungeon.start();

        scanner.close();
    }
}
