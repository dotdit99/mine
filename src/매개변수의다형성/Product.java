package 매개변수의다형성;

public class Product {
    int price;
    int bonusPoint;

}

class TV extends Product{
    TV() {
        this.price = 100;
        this.bonusPoint = 10;
    }
}
class Phone extends Product{
    Phone() {
        this.price = 200;
        this.bonusPoint = 20;
    }
}
class Computer extends Product{
    Computer(){
        this.price = 300;
        this.bonusPoint=30;
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    // Product 클래스의 참조 변수 =
    void buy(Product product){
        money -= product.price;
        bonusPoint += product.bonusPoint;
    }
    void printInfo(){
        System.out.println("잔액: " + money);
        System.out.println("포인트: " + bonusPoint);
    }
}
