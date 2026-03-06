package 스위치실습;

import java.util.Scanner;

public class SwitchEx3_2 {
    public static void main(String[] args) {

        String result = "";
        int price = 0;
        Scanner scanner = new Scanner(System.in);

        // ====== 자판기 메뉴 출력 ======
        System.out.println("=".repeat(32));
        System.out.println("  🥤 자판기에 오신걸 환영합니다!");
        System.out.println("=".repeat(32));
        System.out.println("1. 콜라      - 1,500원");
        System.out.println("2. 사이다    - 1,500원");
        System.out.println("3. 커피      - 1,000원");
        System.out.println("4. 생수      -   500원");
        System.out.println("=".repeat(32));

        // ====== 사용자 입력 ======
        System.out.print("투입 금액 입력 : ");
        int money = scanner.nextInt();

        System.out.print("메뉴 번호 선택 : ");
        char num = scanner.next().charAt(0);

        String[] product = {"", "콜라", "사이다", "커피", "생수"};

        // ====== switch문 : 메뉴 번호에 따라 상품명, 가격 결정 ======
        switch (num) {
            case '1':
                result = product[1];
                price = 1500;
                break;
            case '2':
                result = product[2];
                price = 1500;
                break;
            case '3':
                result = product[3];
                price = 1000;
                break;
            case '4':
                result = product[4];
                price = 500;
                break;
            default:
                System.out.printf("투입 금액 입력 : %,d\n메뉴 번호 선택 : %s\n❌ 없는 메뉴입니다.", money, num);
                return;
        }

        // ====== if문 : 잔액 비교 후 결과 출력 ======
        if (money < price) {
            int shortage = price - money;
            System.out.println("=".repeat(32));
            System.out.println("❌ 잔액이 부족합니다.");
            System.out.printf("투입 금액 : %,d원\n", money);
            System.out.printf("필요 금액 : %,d원\n", price);
            System.out.printf("부족 금액 : %,d원\n", shortage);
            System.out.println("=".repeat(32));
        } else {
            int change = money - price;
            System.out.println("=".repeat(32));
            System.out.printf("✅ %s 가 나왔습니다!\n", result);
            System.out.printf("투입 금액 : %,d원\n", money);
            System.out.printf("상품 금액 : %,d원\n", price);
            System.out.printf("거스름돈  : %,d원\n", change);
            System.out.println("=".repeat(32));
        }
        scanner.close();
    }
}