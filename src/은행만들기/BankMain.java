package 은행만들기;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Bank kakao = new Bank("카카오", 1000);
        Bank shinhan = new Bank("신한", 1000);
        Scanner sc = new Scanner(System.in);
        Bank selectedBank = null;

        // 은행에 대한 입금, 출금, 잔액 조회 메뉴 만들어 보기
        // 계좌 생성 개수 확인 count값 확인
        while (true){
            System.out.println("[1] 은행 선택");
            System.out.println("[2] 입금");
            System.out.println("[3] 출금");
            System.out.println("[4] 잔액 조회");
            System.out.println("[5] 종료");
            int menu = sc.nextInt();
            int money = 0;
            if (menu == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            switch (menu){
                case 1:{
                    System.out.println("입금 금액을 입력하세요: ");
                    money = sc.nextInt();
                    kakao.deposit(money);
                    break;
                }
                case 2: {
                    System.out.println("출금 금액을 입력 하세요: ");
                    money = sc.nextInt();
                    kakao.withdraw(money);
                    break;
                }
                case 3:{
                    kakao.printAccount();
                    break;
                }
                case 4:{
                    System.out.println("계좌 성생 개수: " + Bank.getCount());
                    break;
                }
            }

        }


    }
}
