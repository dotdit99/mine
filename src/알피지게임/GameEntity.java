package 알피지게임;
// ============================================================
//  GameEntity.java — 모든 캐릭터(영웅/몬스터)의 기반 클래스
// ============================================================
public abstract class GameEntity {

    protected String name;
    protected int    hp;
    protected int    maxHp;
    protected int    attack;
    protected int    defense;
    protected int    speed;

    public GameEntity(String name, int hp, int attack, int defense, int speed) {
        this.name    = name;
        this.hp      = hp;
        this.maxHp   = hp;
        this.attack  = attack;
        this.defense = defense;
        this.speed   = speed;
    }

    // 데미지 계산 및 적용 (방어력 차감, 최소 1 보장)
    public int takeDamage(int rawDamage) {
        int dmg = Math.max(1, rawDamage - defense);
        hp = Math.max(0, hp - dmg);
        return dmg;
    }

    // 체력 회복
    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
    }

    public boolean isAlive() { return hp > 0; }

    // HP 바 시각화
    public String hpBar() {
        int barLen   = 20;
        int filled   = (int) ((double) hp / maxHp * barLen);
        String bar   = "█".repeat(filled) + "░".repeat(barLen - filled);
        String color = hp > maxHp * 0.5 ? "🟩" : (hp > maxHp * 0.25 ? "🟨" : "🟥");
        return color + " [" + bar + "] " + hp + "/" + maxHp;
    }

    // Getter
    public String getName()   { return name; }
    public int    getHp()     { return hp; }
    public int    getMaxHp()  { return maxHp; }
    public int    getAttack() { return attack; }
    public int    getDefense(){ return defense; }
    public int    getSpeed()  { return speed; }

    // 추상 메서드: 상태 출력
    public abstract void printStatus();
}
