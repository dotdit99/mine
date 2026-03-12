package 매개변수의다형성;

// 오버로딩: 정적 다형성, 매서드 이름은 동일하고  매개변수의 개수나 타입으로 어떤 메서드가 불릴지 결정하는 것
// 오버라이딩: 동적 다형성, 부모 클래스로 부터 상속 받은 메서드를 재정의해서 사용하는 것

import java.util.Scanner;

public class PolyMain {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("1. TV");
            System.out.println("2. Phone");
            System.out.println("3. Computer");
            System.out.println("4. 정보 보기");
            System.out.println("5. 종료");
            int menu = sc.nextInt();
            switch (menu){
                case 1:{
                    buyer.buy(new TV());
                    break;
                }
                case 2:{
                    buyer.buy(new Phone());
                    break;
                }
                case  3: {
                    buyer.buy(new Computer());
                    break;
                }
                case 4:{
                    buyer.printInfo();
                    break;
                }
                case 5:
                    return;
                default:
                    System.out.println("메뉴 선택이 잘못 되었습니다.");
            }
        }

    }
}
