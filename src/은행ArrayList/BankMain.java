package 은행ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        // NewBank 객체들을 가변적으로 저장하기 위한 ArrayList 생성
        ArrayList<NewBank> bankList = new ArrayList<>();
        // 콘솔 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 프로그램이 수동으로 종료(return)될 때까지 무한히 반복하는 루프
        while (true){
            System.out.println("=".repeat(32));
            System.out.println("[1] 계좌개설 [2] 계좌선택 [3] 전체조회 [4] 계좌수 [5] 종료");
            // 사용자가 선택한 메뉴 번호를 정수로 입력받음
            int menu = sc.nextInt();

            switch (menu){
                // 1번: 새로운 계좌 객체를 만들어 리스트에 저장하는 과정
                case 1:
                    System.out.print("은행명 입력: ");
                    String bankName = sc.next();
                    // nextInt() 사용 후 입력 버퍼에 남아있는 엔터(\n)를 제거하여 다음 입력을 방지함
                    sc.nextLine();
                    System.out.print("예금주 입력: ");
                    String name = sc.next();
                    System.out.print("초기 입금액: ");
                    int money = sc.nextInt();
                    // 입력받은 정보로 NewBank 객체를 즉석 생성하여 bankList의 마지막 칸에 추가
                    bankList.add(new NewBank(bankName, name, money));
                    break;

                // 2번: 리스트에서 특정 계좌를 찾아 입출금 기능을 수행하는 과정
                case 2:
                    System.out.println("----- 계좌 목록 -----");
                    // 향상된 for문을 사용해 리스트 안의 모든 계좌 정보를 화면에 출력함
                    for (NewBank bank : bankList){
                        bank.printAccount();
                        System.out.println("-".repeat(32));
                    }
                    System.out.print("계좌 번호 입력: ");
                    // 찾고자 하는 계좌의 고유 ID를 입력받음
                    int id = sc.nextInt();

                    // 찾은 객체를 임시로 담아둘 참조 변수 (일단 비워둠)
                    NewBank selectedBank = null;
                    // 리스트를 순회하며 입력받은 id와 일치하는 객체가 있는지 검사
                    for (NewBank bank : bankList){
                        if (bank.getId() == id){
                            // 일치하는 객체를 찾으면 해당 객체의 주소값을 selectedBank에 저장
                            selectedBank = bank;
                            // 찾았으므로 반복문 탈출
                            break;
                        }
                    }

                    // 선택된 계좌에 대한 작업을 수행하는 내부 무한 루프 시작
                    while (true){
                        System.out.print("[1] 입금 [2] 출금 [3] 잔액 [4] 이전 메뉴");
                        int subMenu = sc.nextInt();
                        switch (subMenu){
                            case 1:
                                System.out.print("입금 금액 입력: ");
                                int deposit = sc.nextInt();
                                // selectedBank가 null이 아니라는 것은 계좌를 성공적으로 찾았음을 의미함
                                if (selectedBank != null){
                                    selectedBank.deposit(deposit);
                                } else {
                                    System.out.println("입금 계좌가 없습니다.");
                                }
                                break;
                            case 2:
                                System.out.print("출금 금액 입력: ");
                                int withDraw = sc.nextInt();
                                if (selectedBank != null){
                                    selectedBank.withdraw(withDraw);
                                } else {
                                    System.out.println("출금 계좌가 없습니다.");
                                }
                                break;
                            case 3:
                                if (selectedBank != null){
                                    selectedBank.printAccount();
                                } else {
                                    System.out.println("잔액 조회할 계좌가 없습니다.");
                                }
                                break;
                            case 4:
                                // subMenu가 4일 때 switch문을 빠져나감
                                break;
                        }
                        // subMenu가 4라면 내부 while 루프를 종료하고 메인 메뉴로 돌아감
                        if (subMenu == 4) break;
                    }
                    break;

                // 3번: 리스트에 저장된 모든 계좌 객체의 정보를 순차적으로 출력
                case 3:
                    for(NewBank bank : bankList){
                        bank.printAccount();
                        System.out.println("-".repeat(32));
                    }
                    break;

                // 4번: NewBank 클래스에 정의된 정적(static) 변수를 통해 총 생성된 계좌 수를 출력
                case 4:
                    System.out.println("계좌 생성 개수: "+ NewBank.getCount());
                    break;

                // 5번: 프로그램 종료 처리
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    // 사용이 끝난 스캐너 자원을 닫아줌
                    sc.close();
                    // main 메서드를 즉시 종료하여 프로그램 정지
                    return;

                // 잘못된 숫자를 입력했을 경우 처리
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}