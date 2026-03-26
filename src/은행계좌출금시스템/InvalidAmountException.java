package 은행계좌출금시스템;

public class InvalidAmountException extends Exception {
    private final int invalidAmount;

    // 생성자: 문제가 된 금액을 매개변수로 받음
    public InvalidAmountException(int invalidAmount) {
        this.invalidAmount = invalidAmount;
    }

    // getMessage() 오버라이드: 에러 메시지와 입력된 금액 출력
    @Override
    public String getMessage() {
        return "잘못된 금액 입력: [" + invalidAmount + "] 금액은 0원보다 커야 합니다.";
    }
}