package 알피지게임;
// ============================================================
//  Hero.java — 플레이어 영웅 (전사 / 마법사 / 궁수)
// ============================================================
import java.util.ArrayList;
import java.util.List;

public class Hero extends GameEntity {

    public enum JobClass { WARRIOR, MAGE, ARCHER }

    private final JobClass  jobClass;
    private       int       mp;
    private       int       maxMp;
    private       int       level;
    private       int       exp;
    private       int       gold;
    private       int       critChance;      // 치명타 확률 (%)
    private       boolean   defBuff;         // 방어 버프 활성화 여부
    private final Skill[]   skills;
    private final List<Item> inventory;

    public Hero(String name, JobClass jobClass) {
        super(name,
              jobClass == JobClass.WARRIOR ? 200 : (jobClass == JobClass.MAGE ? 130 : 160),
              jobClass == JobClass.WARRIOR ? 40  : (jobClass == JobClass.MAGE ? 55  : 35),
              jobClass == JobClass.WARRIOR ? 15  : (jobClass == JobClass.MAGE ? 5   : 10),
              jobClass == JobClass.WARRIOR ? 8   : (jobClass == JobClass.MAGE ? 12  : 15));
        this.jobClass  = jobClass;
        this.level     = 1;
        this.exp       = 0;
        this.gold      = 100;
        this.critChance= jobClass == JobClass.ARCHER ? 20 : 10;
        this.defBuff   = false;

        // MP 설정
        this.maxMp = jobClass == JobClass.MAGE ? 120 : (jobClass == JobClass.ARCHER ? 80 : 60);
        this.mp    = this.maxMp;

        // 직업별 스킬 배정
        this.skills = switch (jobClass) {
            case WARRIOR -> Skill.warriorSkills();
            case MAGE    -> Skill.mageSkills();
            case ARCHER  -> Skill.archerSkills();
        };

        this.inventory = new ArrayList<>();
        // 시작 아이템
        inventory.add(new Item("소형 HP 포션", Item.ItemType.HP_POTION, 80, 50, "🧪"));
        inventory.add(new Item("소형 HP 포션", Item.ItemType.HP_POTION, 80, 50, "🧪"));
    }

    // ── 직업 정보 ──────────────────────────────────────────────
    public String jobEmoji() {
        return switch (jobClass) {
            case WARRIOR -> "⚔️  전사";
            case MAGE    -> "🔮 마법사";
            case ARCHER  -> "🏹 궁수";
        };
    }

    // ── 전투: 일반 공격 ────────────────────────────────────────
    public int normalAttack(GameEntity target) {
        int dmg = attack;
        boolean isCrit = Math.random() * 100 < critChance;
        if (isCrit) dmg = (int)(dmg * 1.8);
        return target.takeDamage(dmg);
    }

    // ── 전투: 스킬 사용 ────────────────────────────────────────
    // returns: 실제 데미지 (회복/버프는 0 반환)
    public int useSkill(int skillIndex, GameEntity target) {
        Skill skill = skills[skillIndex];
        if (mp < skill.getMpCost()) return -1; // MP 부족
        mp -= skill.getMpCost();

        return switch (skill.getType()) {
            case ATTACK -> {
                int dmg = (int)(attack * skill.getPower() / 100.0);
                boolean crit = Math.random() * 100 < critChance;
                if (crit) dmg = (int)(dmg * 1.5);
                yield target.takeDamage(dmg);
            }
            case HEAL -> {
                int healAmt = (int)(maxHp * skill.getPower() / 100.0);
                heal(healAmt);
                yield 0;
            }
            case BUFF -> {
                if (skill.getName().equals("방패막기")) {
                    defense += skill.getPower();
                    defBuff = true;
                } else {
                    critChance += skill.getPower();
                }
                yield 0;
            }
        };
    }

    // ── 아이템 사용 ────────────────────────────────────────────
    public String useItem(int index) {
        if (index < 0 || index >= inventory.size()) return "잘못된 선택입니다.";
        Item item = inventory.remove(index);
        return switch (item.getType()) {
            case HP_POTION   -> { heal(item.getValue()); yield "HP를 " + item.getValue() + " 회복했습니다!"; }
            case MP_POTION   -> { mp = Math.min(maxMp, mp + item.getValue()); yield "MP를 " + item.getValue() + " 회복했습니다!"; }
            case ATTACK_UP   -> { attack += item.getValue(); yield "공격력이 " + item.getValue() + " 증가했습니다!"; }
            case DEFENSE_UP  -> { defense += item.getValue(); yield "방어력이 " + item.getValue() + " 증가했습니다!"; }
            case FULL_HEAL   -> { hp = maxHp; mp = maxMp; yield "HP와 MP가 완전히 회복되었습니다!"; }
        };
    }

    // ── 경험치 & 레벨업 ───────────────────────────────────────
    public boolean gainExp(int amount) {
        exp += amount;
        int required = level * 100;
        if (exp >= required) {
            exp -= required;
            level++;
            levelUp();
            return true;
        }
        return false;
    }

    private void levelUp() {
        int hpGain  = switch (jobClass) { case WARRIOR -> 30; case MAGE -> 15; case ARCHER -> 20; };
        int atkGain = switch (jobClass) { case WARRIOR -> 5;  case MAGE -> 8;  case ARCHER -> 6;  };
        int defGain = switch (jobClass) { case WARRIOR -> 3;  case MAGE -> 1;  case ARCHER -> 2;  };
        maxHp   += hpGain;
        hp       = maxHp;           // 레벨업 시 전체 회복
        mp       = maxMp;
        attack  += atkGain;
        defense += defGain;
    }

    // ── 방어 버프 해제 (매 턴 종료 후) ───────────────────────
    public void clearDefBuff() {
        if (defBuff) {
            defense -= 10;
            defBuff = false;
        }
    }

    // ── 상태 출력 ──────────────────────────────────────────────
    @Override
    public void printStatus() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.printf ("│  %s  Lv.%-2d  %s%n", name, level, jobEmoji());
        System.out.println("│");
        System.out.println("│  HP  " + hpBar());
        System.out.printf ("│  MP  💙 [%3d / %3d]%n", mp, maxMp);
        System.out.printf ("│  EXP ⭐ %d / %d%n", exp, level * 100);
        System.out.printf ("│  ATK ⚔️  %-3d  DEF 🛡️  %-3d  SPD 💨 %-3d%n", attack, defense, speed);
        System.out.printf ("│  💰 골드: %dG%n", gold);
        System.out.println("└─────────────────────────────────────┘");
    }

    // ── Getter / 기타 ─────────────────────────────────────────
    public int       getMp()        { return mp; }
    public int       getMaxMp()     { return maxMp; }
    public int       getLevel()     { return level; }
    public int       getExp()       { return exp; }
    public int       getGold()      { return gold; }
    public int       getCritChance(){ return critChance; }
    public Skill[]   getSkills()    { return skills; }
    public List<Item>getInventory() { return inventory; }
    public JobClass  getJobClass()  { return jobClass; }

    public void addGold(int amount)  { gold += amount; }
    public boolean spendGold(int g)  { if (gold < g) return false; gold -= g; return true; }
    public void addItem(Item item)   { inventory.add(item); }
}
