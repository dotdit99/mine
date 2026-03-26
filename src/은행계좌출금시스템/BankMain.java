package 은행계좌출금시스템;

public class BankMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000);
        
        // 테스트 1 : 정상 입금
        try {
            account.deposit(5000);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        // 테스트 2 : 0원 입금 시도
        try {
            account.deposit(0);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        // 테스트 3 : 정상 출금
        try {
            account.withdraw(3000);
        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        // 테스트 4 : 잔액 초과 출금 시도
        try {
            account.withdraw(50000);
        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        // 테스트 5 : -500원 출금 시도 → finally로 최종 잔액 출력
        try {
            account.withdraw(-500);
        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("최종 잔액: " + account.getBalance() + "원"); // ✅ finally 활용
        }
    }
}