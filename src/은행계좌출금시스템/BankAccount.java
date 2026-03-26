package 은행계좌출금시스템;

public class BankAccount {
    int balance;

    // 생성자 초기 잔액 설정
    public BankAccount(int balance) {
        this.balance = balance;
    }

    // 잔액 조회
    public int getBalance() {
        return balance;
    }

    // 입금 메서드
    public void deposit(int amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        balance += amount;
        System.out.println(amount + "원 입금 완료. 현재 잔액: " + balance + "원");
    }

    // 출금 메서드
    public void withdraw(int amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(amount, balance);
        }
        balance -= amount;
        System.out.println(amount + "원 출금 완료. 현재 잔액: " + balance + "원");
    }
}