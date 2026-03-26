package 은행계좌출금시스템;

public class InsufficientBalanceException extends Exception {
    private final int withdraw;
    private final int currentBalance;

    InsufficientBalanceException(int withdraw, int currentBalance) {
        this.withdraw = withdraw;
        this.currentBalance = currentBalance;
    }

    @Override
    public String getMessage() {
        return "출금 요청 금액은 " + withdraw + " 현재 잔액은 " + currentBalance;
    }
}
