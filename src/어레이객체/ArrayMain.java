package 어레이객체;

import java.util.List;
import java.util.ArrayList;

public class ArrayMain {
    public static void main(String[] args) {
        List<Menu> menulist = new ArrayList<>();
        menulist.add(new Menu("Americano", 2000, "Coffee", "그냥 커피"));
        menulist.add(new Menu("Latte", 4000, "Coffee", "우유 커피"));
        menulist.add(new Menu("Moca", 5000, "Coffee", "초콜릿 커피"));
        menulist.add(new Menu("Cold Brew", 5000, "Coffee", "콜드브루     커피"));


    }
}

class Menu{
    String name;
    int price;
    String category;
    String description;

    public Menu(String name, int price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }
    @Override
    public String toString() {
        return "이름 : " + name + "\n" + "가격: " + price + "\n" + "분류: " + category + "\n" + "설명" + description + "\n";
    }
}