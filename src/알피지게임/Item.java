package 알피지게임;
// ============================================================
//  Item.java — 아이템 정의 및 인벤토리
// ============================================================
import java.util.ArrayList;
import java.util.List;

public class Item {

    public enum ItemType { HP_POTION, MP_POTION, ATTACK_UP, DEFENSE_UP, FULL_HEAL }

    private final String   name;
    private final ItemType type;
    private final int      value;
    private final int      price;
    private final String   emoji;

    public Item(String name, ItemType type, int value, int price, String emoji) {
        this.name  = name;
        this.type  = type;
        this.value = value;
        this.price = price;
        this.emoji = emoji;
    }

    // 상점 아이템 목록
    public static List<Item> shopItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("소형 HP 포션",   ItemType.HP_POTION,   80,  50, "🧪"));
        items.add(new Item("대형 HP 포션",   ItemType.HP_POTION,  200, 120, "🍶"));
        items.add(new Item("MP 포션",        ItemType.MP_POTION,   60,  60, "💧"));
        items.add(new Item("공격력 강화제",  ItemType.ATTACK_UP,   15, 100, "⚡"));
        items.add(new Item("방어력 강화제",  ItemType.DEFENSE_UP,  10,  80, "🔩"));
        items.add(new Item("완전 회복약",    ItemType.FULL_HEAL,    0, 300, "💊"));
        return items;
    }

    public String   getName()  { return name; }
    public ItemType getType()  { return type; }
    public int      getValue() { return value; }
    public int      getPrice() { return price; }
    public String   getEmoji() { return emoji; }

    @Override
    public String toString() {
        return emoji + " " + name + " (가격: " + price + "G)";
    }
}
