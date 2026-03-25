package 알피지게임;
// ============================================================
//  Monster.java — 몬스터 정의 (일반 / 보스)
// ============================================================
import java.util.Random;

public class Monster extends GameEntity {

    public enum MonsterType { NORMAL, ELITE, BOSS }

    private final MonsterType type;
    private final int         expReward;
    private final int         goldReward;
    private final String      emoji;
    private       boolean     isEnraged;    // 체력 25% 이하 → 분노 상태
    private final Random      rng = new Random();

    public Monster(String name, int hp, int attack, int defense, int speed,
                   MonsterType type, int expReward, int goldReward, String emoji) {
        super(name, hp, attack, defense, speed);
        this.type       = type;
        this.expReward  = expReward;
        this.goldReward = goldReward;
        this.emoji      = emoji;
        this.isEnraged  = false;
    }

    // ── 층별 몬스터 팩토리 ────────────────────────────────────

    public static Monster[] floor1Monsters() {
        return new Monster[]{
            new Monster("슬라임",      40,  8,  0, 5, MonsterType.NORMAL,  20,  10, "🟢"),
            new Monster("고블린",      55, 12,  2, 8, MonsterType.NORMAL,  30,  15, "👺"),
            new Monster("박쥐",        35, 10,  1,12, MonsterType.NORMAL,  25,  12, "🦇"),
            new Monster("해골 전사",   80, 18,  5, 6, MonsterType.ELITE,   60,  40, "💀"),
            new Monster("대형 슬라임", 150, 25, 8, 4, MonsterType.BOSS,   120,  80, "👾"),
        };
    }

    public static Monster[] floor2Monsters() {
        return new Monster[]{
            new Monster("오크",         90, 20,  6, 6, MonsterType.NORMAL,  50,  30, "👹"),
            new Monster("독거미",       70, 18,  3,10, MonsterType.NORMAL,  45,  25, "🕷️"),
            new Monster("트롤",        120, 28,  8, 5, MonsterType.ELITE,   90,  60, "🧌"),
            new Monster("오크 족장",   200, 40, 12, 7, MonsterType.BOSS,   180, 120, "👑"),
        };
    }

    public static Monster[] floor3Monsters() {
        return new Monster[]{
            new Monster("언데드 기사",  130, 30, 12, 7, MonsterType.NORMAL,  70,  50, "⚫"),
            new Monster("불꽃 정령",   110, 35,  6,10, MonsterType.NORMAL,  65,  45, "🔥"),
            new Monster("석고 골렘",   180, 25, 18, 4, MonsterType.ELITE,  120,  90, "🗿"),
            new Monster("어둠의 마법사",220, 50,  8,12, MonsterType.BOSS,  220, 160, "🧙"),
        };
    }

    public static Monster[] floor4Monsters() {
        return new Monster[]{
            new Monster("드래곤 새끼",  160, 40, 10,10, MonsterType.NORMAL,  100,  70, "🐲"),
            new Monster("타락한 기사", 190, 45, 15, 8, MonsterType.NORMAL,  110,  80, "🗡️"),
            new Monster("흡혈귀 군주", 250, 55, 12,14, MonsterType.BOSS,   280, 200, "🧛"),
        };
    }

    public static Monster[] floor5Monsters() {
        return new Monster[]{
            new Monster("심연의 괴물",  200, 50, 15,10, MonsterType.NORMAL,  130,  90, "👁️"),
            new Monster("타락한 신수",  280, 60, 20,12, MonsterType.ELITE,  180, 130, "🦁"),
            new Monster("마왕 다크로스", 500, 80, 20,10, MonsterType.BOSS,  500, 400, "😈"),
        };
    }

    // ── 몬스터 행동 AI ────────────────────────────────────────
    public int act(Hero hero) {
        // 분노 체크
        if (!isEnraged && hp < maxHp * 0.25) {
            isEnraged = true;
            attack = (int)(attack * 1.4);
            System.out.println("  💢 " + emoji + " " + name + "이(가) 분노했다! 공격력이 급상승!");
        }

        // 보스 특수 패턴
        if (type == MonsterType.BOSS && rng.nextInt(100) < 25) {
            return bossSkill(hero);
        }

        // 일반 공격
        return hero.takeDamage(attack + rng.nextInt(6) - 3);
    }

    private int bossSkill(Hero hero) {
        int roll = rng.nextInt(3);
        return switch (roll) {
            case 0 -> { System.out.println("  💥 " + name + "의 강력한 일격!"); yield hero.takeDamage((int)(attack * 1.8)); }
            case 1 -> { System.out.println("  🌪️ " + name + "의 광역 충격파!"); yield hero.takeDamage((int)(attack * 1.5)); }
            default -> { System.out.println("  ☠️ " + name + "의 저주의 일격!"); yield hero.takeDamage(attack + 20); }
        };
    }

    @Override
    public void printStatus() {
        String typeTag = switch (type) {
            case NORMAL -> "";
            case ELITE  -> " [정예]";
            case BOSS   -> " ★BOSS★";
        };
        System.out.printf("  %s %s%s%n", emoji, name, typeTag);
        System.out.println("  HP " + hpBar());
    }

    public MonsterType getType()       { return type; }
    public int         getExpReward()  { return expReward; }
    public int         getGoldReward() { return goldReward; }
    public String      getEmoji()      { return emoji; }
    public boolean     isEnraged()     { return isEnraged; }
}
