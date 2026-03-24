package 컴페어러블;

import java.util.TreeSet;

public class CompMain {
    public static void main(String[] args) {
        TreeSet<Car> cars = new TreeSet<>();
        cars.add(new Car("BMW", 2010, "Red"));
        cars.add(new Car("Mercedes", 2015, "Blue"));
        cars.add(new Car("Mercedes", 2015, "Black"));
        cars.add(new Car("Toyota", 2013, "White"));
        cars.add(new Car("Honda", 2013, "Silver"));

        for (Car car : cars) {
            System.out.println("이름 : " + car.name);
            System.out.println("연식 : " + car.year);
            System.out.println("색상 : " + car.color);
            System.out.println("-----------------------------");
        }
    }
}

class Car implements Comparable<Car> {
    String name;
    int year;
    String color;

    public Car(String name, int year, String color) {
        this.name = name;
        this.year = year;
        this.color = color;
    }

    @Override
    public int compareTo(Car o) {
        // 1. 연식 기준 (최신순 내림차순)
        if (this.year != o.year) {
            return o.year - this.year;
        }

        // 2. 이름 기준 (사전순 오름차순)
        if (!this.name.equals(o.name)) {
            return this.name.compareTo(o.name);
        }

        // ✅ 수정: 색상 기준 (사전순 오름차순) + return 추가
        return this.color.compareTo(o.color);
    }
}