package 은행ArrayList;


import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        ArrayList<NewBank> bankList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=".repeat(32));
            System.out.println("[1] 계좌개설 [2] 계좌선택 [3] 전체조회 [4] 계좌수 [5] 종료");
            int menu = sc.nextInt();

            switch (menu){
                case 1:
                    System.out.print("은행명 입력: ");
                    String bankName = sc.next();
                    sc.nextLine();
                    System.out.print("예금주 입력: ");
                    String name = sc.next();
                    System.out.print("초기 입금액: ");
                    int money = sc.nextInt();
                    bankList.add(new NewBank(bankName, name, money)); // 리스트에 마지막에 새로운 객체를 추가
                    break;
                case 2:
                    // 전체 계좌 목록 보여주기
                    System.out.println("----- 계좌 목록 -----");
                    for (NewBank bank : bankList){
                        bank.printAccount();
                        System.out.println("-".repeat(32));
                    }
                    System.out.print("계좌 번호 입력: ");
                    int id = sc.nextInt();

                    NewBank selectedBank = null; // 가르키는 대상이 없음
                    for (NewBank bank : bankList){
                        if (bank.getId() == id){ // 입력 받은 계좌 번호와 일치하는 계좌의 객체를 반환
                            selectedBank = bank;
                            break;
                        }
                    }

                    while (true){
                        System.out.print("[1] 입금 [2] 출금 [3] 잔액 [4] 이전 메뉴");
                        int subMenu = sc.nextInt();
                        switch (subMenu){
                            case 1:
                                System.out.print("입금 금액 입력: ");
                                int deposit = sc.nextInt();
                                if (selectedBank != null){
                                    selectedBank.deposit(deposit);
                                }else {
                                    System.out.println("입금 계좌가 없습니다.");
                                }
                                break;
                            case 2:
                                System.out.print("출금 금액 입력: ");
                                int withDraw = sc.nextInt();
                                if (selectedBank != null){
                                    selectedBank.withdraw(withDraw);
                                }else {
                                    System.out.println("출금 계좌가 없습니다.");
                                }
                                break;
                            case 3:
                                if (selectedBank != null){
                                    selectedBank.printAccount();
                                }else {
                                    System.out.println("잔액 조회할 계좌가 없습니다.");
                                }
                                break;
                            case 4:
                                break;
                        }
                        if (subMenu == 4) break;
                    }

                    break;
                case 3:
                    for(NewBank bank : bankList){
                        bank.printAccount();
                        System.out.println("-".repeat(32));
                    }
                    break;
                case 4:
                    System.out.println("계좌 생성 개수: "+ NewBank.getCount());
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}
