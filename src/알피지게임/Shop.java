package 알피지게임;
// ============================================================
//  Shop.java — 층간 상점 시스템
// ============================================================
import java.util.List;
import java.util.Scanner;

public class Shop {

    private final Scanner scanner;

    public Shop(Scanner scanner) {
        this.scanner = scanner;
    }

    public void open(Hero hero) {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  🏪  던전 상점에 오신 것을 환영합니다!  ║");
        System.out.println("╚════════════════════════════════════════╝");

        List<Item> shopItems = Item.shopItems();

        while (true) {
            System.out.printf("%n  💰 보유 골드: %dG%n%n", hero.getGold());
            System.out.println("  ┌──────────────────────────────────────┐");
            for (int i = 0; i < shopItems.size(); i++) {
                Item item = shopItems.get(i);
                String canBuy = hero.getGold() >= item.getPrice() ? "" : " ❌";
                System.out.printf("  │  %d. %-20s %4dG%s%n",
                        i + 1, item.getEmoji() + " " + item.getName(), item.getPrice(), canBuy);
            }
            System.out.println("  └──────────────────────────────────────┘");
            System.out.println("   0. 상점 나가기");

            int choice = GameUI.getIntInput(scanner, "  선택 > ", 0, shopItems.size());
            if (choice == 0) break;

            Item selected = shopItems.get(choice - 1);
            if (!hero.spendGold(selected.getPrice())) {
                System.out.println("  ❌ 골드가 부족합니다!");
            } else {
                hero.addItem(new Item(
                        selected.getName(), selected.getType(),
                        selected.getValue(), selected.getPrice(), selected.getEmoji()));
                System.out.printf("  ✅ %s %s 구매 완료! (잔여: %dG)%n",
                        selected.getEmoji(), selected.getName(), hero.getGold());
            }
        }
        System.out.println("  👋 상점을 나갔습니다.");
    }
}
