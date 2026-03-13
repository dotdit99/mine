package 은행ArrayList;

// ArrayList 활용 예제

public class NewBank {
    private static int count = 0;
    private int id; // 계좌 식별용 번호
    private int account; // 잔액
    private String bank; // 은행 이름
    private String name; // 예금주 이름

    public NewBank(String bank, String name,int account){
        this.bank = bank;
        this.name = name;
        this.account = account;
        count++; // 계좌 생성 개수
        id = count + 10000; // 계좌 식별용 번호는 자동 생성
    }

    public int getId(){
        return id;
    }

    public static int getCount(){
        return count;
    }
    // 예금 기능 구현: 매개변수로 값을 전달 받아 account에 누적
    public void deposit(final int money){ //입금 금액이 변경되지 않도록 final 붙임
        this.account += money;
        System.out.println("금액 " + money + "원이 입급되었습니다.");
        System.out.println("현재 금액은 " + this.account + "원 입니다.");
    }
    // 출금 기능 구현: 매개변수로 값을 전달 받아 account의 값을 차감하는 기능 구현 ( 출금 금액 예금 금액보다 작거나 같아야
    public void withdraw(final int money){
        if (money <= account){
            account -= money;
        }else {
            System.out.println("잔액이 부족합니다.");
        }
    }
    public void printAccount(){
        System.out.println("은행명: " + bank);
        System.out.println("예금주 : " + name);
        System.out.println("계좌번호 : " + id);
        System.out.println("잔액 : " + account);
    }
}

