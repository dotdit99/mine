package 컴페어레이터;

// Comparator: 두 개의 객체를 입력으로 받아서 비교해주는 인터페이스

import java.util.ArrayList;
import java.util.List;

public class CompMain {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("Apple", 1000));
        list.add(new Fruit("Banana", 800));
        list.add(new Fruit("Orange", 900));
        list.add(new Fruit("Pear", 700));
        list.add(new Fruit("Grape", 600));
        list.add(new Fruit("Strawberry", 500));
        list.add(new Fruit("Watermelon", 400));


    }
}

class FruitComparator implements java.util.Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o2.getPrice() - o1.getPrice(); // 뒤에 값이 크면 양수가 반환되고 양수이면 정렬 조건
    }
}

class Fruit {
    String name;
    int price;

    Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price;
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
}
