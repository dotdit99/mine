package 알피지게임;

// ============================================================
//  Skill.java — 스킬 정의 (공격/회복/버프)
// ============================================================
public class Skill {

    public enum SkillType { ATTACK, HEAL, BUFF }

    private final String    name;
    private final String    description;
    private final SkillType type;
    private final int       power;      // 데미지 or 회복량
    private final int       mpCost;
    private final String    emoji;

    public Skill(String name, String description, SkillType type,
                 int power, int mpCost, String emoji) {
        this.name        = name;
        this.description = description;
        this.type        = type;
        this.power       = power;
        this.mpCost      = mpCost;
        this.emoji       = emoji;
    }

    // 전사 스킬 목록
    public static Skill[] warriorSkills() {
        return new Skill[]{
            new Skill("강타",   "강력한 한 방! (데미지 x2.0)",        SkillType.ATTACK, 200, 20, "⚔️"),
            new Skill("방패막기","방어력 일시 증가 (+10)",              SkillType.BUFF,   10,  15, "🛡️"),
            new Skill("전투의 함성","적 전체 공포 (데미지 x1.5 + 기절)",SkillType.ATTACK, 150, 30, "📣"),
        };
    }

    // 마법사 스킬 목록
    public static Skill[] mageSkills() {
        return new Skill[]{
            new Skill("파이어볼",  "강력한 마법 폭발 (데미지 x2.5)",  SkillType.ATTACK, 250, 30, "🔥"),
            new Skill("아이스 볼트","얼음 화살 연사 (데미지 x1.8)",   SkillType.ATTACK, 180, 20, "❄️"),
            new Skill("힐",       "체력 40% 회복",                    SkillType.HEAL,   40,  25, "✨"),
        };
    }

    // 궁수 스킬 목록
    public static Skill[] archerSkills() {
        return new Skill[]{
            new Skill("연속 사격", "3연속 화살 (데미지 x1.5 x3)",     SkillType.ATTACK, 150, 25, "🏹"),
            new Skill("독화살",   "독을 바른 화살 (데미지 x1.2 + 독)",SkillType.ATTACK, 120, 20, "☠️"),
            new Skill("독수리 눈","치명타 확률 증가 (+30%)",           SkillType.BUFF,   30,  15, "👁️"),
        };
    }

    public String    getName()        { return name; }
    public String    getDescription() { return description; }
    public SkillType getType()        { return type; }
    public int       getPower()       { return power; }
    public int       getMpCost()      { return mpCost; }
    public String    getEmoji()       { return emoji; }
}
