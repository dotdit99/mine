package 해시맵응용;

public class Menu {
    private String name;
    private int price;
    private String category;
    private String desc;

    public Menu(String name, int price, String category, String desc) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "메뉴: " + name + "\n" +
                "가격: "  + price + "\n" +
                "카테고리: " + category + "\n" +
                "설명: " + desc + "\n" +
                "-----------------------------";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
