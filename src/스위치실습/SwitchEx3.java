package 스위치실습;

// 자판기 프로그램 구현하기

import java.util.Scanner;

public class SwitchEx3 {
    public static void main(String[] args) {
        String result;
        int price = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("투입 금액을 입력하세요: ");
        int money = scanner.nextInt();
        System.out.print("메뉴 번호를 입력하세요: ");
        char num = scanner.next().charAt(0);
        String[] product = {"","콜라","사이다","커피","생수"};
        switch (num){
            case '1':
                result = product[1];
                price = 1500;
                break;
            case '2':
                result = product[1];
                price = 1500;
                break;
            case '3':
                result = product[1];
                price = 1500;
                break;
            case '4':
                result = product[1];
                price = 1500;
                break;

            default:
                System.out.printf("투입 금액 입력 : %,d\n메뉴 번호 선택 : %s\n❌ 없는 메뉴 입니다.",money, num);
                return;
        }

    }
}
