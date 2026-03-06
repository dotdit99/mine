package 자판기프로그램;

//메뉴 선택이 잘못된 경우 재 입력 요구하도록 수정: 반복문 사용

import java.util.Scanner;

public class VendingMachineMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 메뉴판 출력
        System.out.println("=".repeat(32));
        System.out.println("\t\t자판기 메뉴 프로그램");
        System.out.println("=".repeat(32));
        System.out.println("\t1. 콜라   : 1,500원");
        System.out.println("\t2. 사이다  : 1,500원");
        System.out.println("\t3. 커피   : 1,000원");
        System.out.println("\t4. 생수   : 500원");
        System.out.println("=".repeat(32));


        String item = ""; // 선택된 메뉴를 담기 위한 변수
        int price = 0; // 선택된 메뉴 가격
        int money = 0; // 지역 변수는 BLock Scope를 따르기 때문에 While 밖에서 정의
        int menu = 0;
        while (true){ // 무한 반복문에 대한 탈출 조건도 break
            // 투입 금액 입력 받기
            System.out.print("투입 금액 입력: ");
            money = sc.nextInt();

            // 메뉴 번호 입력 받기
            System.out.print("메뉴 번호 입력: ");
            menu = sc.nextInt();

            switch(menu){
                case 1:
                    item = "콜라";
                    price = 1500;
                    break;
                case 2:
                    item = "사이다";
                    price = 1500;
                case 3:
                    item = "커피";
                    price = 100;
                    break;
                case 4:
                    item = "생수";
                    price = 500;
                    break;
                default:
                    System.out.println("메뉴 선택이 잘못 되었습니다.");
                    continue; // 반목문의 조건식으로 이동함
            }
            break;
        }
        System.out.println("=".repeat(32));

        if (money < price) { // 잔액이 부족한 경우
            System.out.println("잔액이 부족합니다.");
            System.out.println("투입 금액: "+ String.format("%,d", money) + "원");
            System.out.println("필요 금액: " + price + "원");
            System.out.println("부족 금액: " + (price -money) + "원");
        }else{
            int change = money - price; // 거스름돈 계산
            System.out.println("투입 금액: "+ String.format("%,d", money) + "원");
            System.out.println("상품 금액: "+ price + "원");
            System.out.println("거스름돈: "+ change + "원");
        }
        System.out.println("=".repeat(32));
        sc.close();


    }
}
