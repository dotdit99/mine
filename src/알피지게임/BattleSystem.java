package 알피지게임;

// ============================================================
//  BattleSystem.java — 턴제 전투 시스템
// ============================================================
import java.util.Scanner;

public class BattleSystem {

    private final Scanner scanner;

    public BattleSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    // ── 전투 진행 (returns: 승리 여부) ────────────────────────
    public boolean fight(Hero hero, Monster monster) {

        System.out.println();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("  ⚔️  전투 시작! %s %s VS %s %s%n",
                hero.getName(), hero.jobEmoji(), monster.getEmoji(), monster.getName());
        if (monster.getType() == Monster.MonsterType.BOSS) {
            System.out.println("  ★★★  보스 등장! ★★★");
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        GameUI.pause(800);

        int turn = 1;
        while (hero.isAlive() && monster.isAlive()) {

            System.out.println("\n  ── " + turn + "턴 ──────────────────────────");
            printBattleStatus(hero, monster);

            // 속도에 따라 선공 결정
            boolean heroFirst = hero.getSpeed() >= monster.getSpeed();

            if (heroFirst) {
                if (!heroTurn(hero, monster)) break;
                if (monster.isAlive()) monsterTurn(hero, monster);
            } else {
                monsterTurn(hero, monster);
                if (hero.isAlive()) heroTurn(hero, monster);
            }

            turn++;
        }

        return resolveBattle(hero, monster);
    }

    // ── 영웅 행동 ─────────────────────────────────────────────
    private boolean heroTurn(Hero hero, Monster monster) {
        System.out.println("\n  📋 행동을 선택하세요:");
        System.out.println("   1. ⚔️  일반 공격");
        System.out.println("   2. ✨  스킬 사용");
        System.out.println("   3. 🎒  아이템 사용");

        int choice = GameUI.getIntInput(scanner, "  선택 > ", 1, 3);

        switch (choice) {
            case 1 -> {
                int dmg = hero.normalAttack(monster);
                System.out.printf("  ⚔️  %s의 공격! → %s에게 %d 데미지!%n",
                        hero.getName(), monster.getName(), dmg);
            }
            case 2 -> {
                if (!skillMenu(hero, monster)) heroTurn(hero, monster);
            }
            case 3 -> {
                if (!itemMenu(hero)) heroTurn(hero, monster);
            }
        }

        hero.clearDefBuff();
        GameUI.pause(500);
        return true;
    }

    // ── 스킬 메뉴 ─────────────────────────────────────────────
    private boolean skillMenu(Hero hero, Monster monster) {
        Skill[] skills = hero.getSkills();
        System.out.println("\n  ✨ 스킬 목록 (현재 MP: " + hero.getMp() + ")");
        for (int i = 0; i < skills.length; i++) {
            String mpTag = hero.getMp() >= skills[i].getMpCost() ? "" : " ⛔MP부족";
            System.out.printf("   %d. %s %s — %s (MP: %d)%s%n",
                    i + 1, skills[i].getEmoji(), skills[i].getName(),
                    skills[i].getDescription(), skills[i].getMpCost(), mpTag);
        }
        System.out.println("   0. 돌아가기");

        int choice = GameUI.getIntInput(scanner, "  선택 > ", 0, skills.length);
        if (choice == 0) return false;

        int result = hero.useSkill(choice - 1, monster);
        if (result == -1) {
            System.out.println("  ⛔ MP가 부족합니다!");
            return false;
        }

        Skill used = skills[choice - 1];
        switch (used.getType()) {
            case ATTACK -> System.out.printf("  %s %s 발동! → %s에게 %d 데미지!%n",
                    used.getEmoji(), used.getName(), monster.getName(), result);
            case HEAL   -> System.out.printf("  %s %s 발동! → HP 회복! (현재 HP: %d)%n",
                    used.getEmoji(), used.getName(), hero.getHp());
            case BUFF   -> System.out.printf("  %s %s 발동! → 능력치 강화!%n",
                    used.getEmoji(), used.getName());
        }
        return true;
    }

    // ── 아이템 메뉴 ───────────────────────────────────────────
    private boolean itemMenu(Hero hero) {
        if (hero.getInventory().isEmpty()) {
            System.out.println("  🎒 인벤토리가 비어있습니다.");
            return false;
        }
        System.out.println("\n  🎒 인벤토리");
        var inv = hero.getInventory();
        for (int i = 0; i < inv.size(); i++) {
            System.out.printf("   %d. %s%n", i + 1, inv.get(i));
        }
        System.out.println("   0. 돌아가기");

        int choice = GameUI.getIntInput(scanner, "  선택 > ", 0, inv.size());
        if (choice == 0) return false;

        String msg = hero.useItem(choice - 1);
        System.out.println("  🎒 " + msg);
        return true;
    }

    // ── 몬스터 행동 ───────────────────────────────────────────
    private void monsterTurn(Hero hero, Monster monster) {
        int dmg = monster.act(hero);
        System.out.printf("  %s %s의 공격! → %s에게 %d 데미지!%n",
                monster.getEmoji(), monster.getName(), hero.getName(), dmg);
        GameUI.pause(400);
    }

    // ── 전투 결과 처리 ────────────────────────────────────────
    private boolean resolveBattle(Hero hero, Monster monster) {
        System.out.println();
        if (hero.isAlive()) {
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  🎉 승리!");
            int exp  = monster.getExpReward();
            int gold = monster.getGoldReward();
            hero.addGold(gold);
            boolean leveledUp = hero.gainExp(exp);
            System.out.printf("  ⭐ 경험치 +%d   💰 골드 +%d%n", exp, gold);
            if (leveledUp) {
                System.out.println();
                System.out.println("  ╔══════════════════════════╗");
                System.out.printf ("  ║  🆙 LEVEL UP! → Lv.%d     ║%n", hero.getLevel());
                System.out.println("  ║  HP/MP 전체 회복!          ║");
                System.out.println("  ╚══════════════════════════╝");
            }
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            return true;
        } else {
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  💀 패배...");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            return false;
        }
    }

    // ── 전투 중 상태 표시 ─────────────────────────────────────
    private void printBattleStatus(Hero hero, Monster monster) {
        System.out.printf("  %s  HP %s%n", hero.getName(), hero.hpBar());
        System.out.printf("  MP 💙 %d/%d%n", hero.getMp(), hero.getMaxMp());
        System.out.println();
        monster.printStatus();
    }
}
