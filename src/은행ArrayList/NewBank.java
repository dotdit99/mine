package 은행ArrayList;

public class NewBank {
    // 은행 이름을 저장하는 변수
    String bankName;
    // 예금주 이름을 저장하는 변수
    String name;
    // 현재 잔액을 저장하는 변수
    int account;
    // 각 계좌의 고유 번호를 저장하는 변수
    int id;

    // 모든 객체가 공유하는 정적 변수로, 생성된 계좌의 총 개수를 관리함
    static int count = 0;

    // 계좌 생성을 위한 생성자: 은행명, 예금주명, 초기 입금액을 매개변수로 받음
    public NewBank(String bankName, String name, int money) {
        // 매개변수로 받은 은행명을 클래스 멤버 변수에 대입
        this.bankName = bankName;
        // 매개변수로 받은 예금주명을 클래스 멤버 변수에 대입
        this.name = name;
        // 매개변수로 받은 초기 금액을 잔액 변수에 대입
        this.account = money;

        // 새로운 계좌가 생성될 때마다 공유 변수 count를 1 증가시킴
        count++;
        // 증가된 count 값을 이 객체의 고유 id로 설정 (1번, 2번... 순서대로 부여됨)
        this.id = count;
    }

    // 입금 기능을 수행하는 메서드
    public void deposit(int money) {
        // 기존 잔액(account)에 입금액(money)을 누적하여 더함
        this.account += money;
        System.out.println(name + "님의 계좌에 " + money + "원이 입금되었습니다.");
    }

    // 출금 기능을 수행하는 메서드
    public void withdraw(int money) {
        // 현재 잔액이 출금하려는 금액보다 크거나 같은지 확인
        if (this.account >= money) {
            // 잔액이 충분하면 출금액만큼 차감
            this.account -= money;
            System.out.println(money + "원이 출금되었습니다.");
        } else {
            // 잔액이 부족하면 경고 메시지 출력
            System.out.println("잔액이 부족하여 출금할 수 없습니다.");
        }
    }

    // 계좌의 상세 정보를 출력하는 메서드
    public void printAccount() {
        System.out.println("계좌번호: " + id);
        System.out.println("은행명: " + bankName);
        System.out.println("예금주: " + name);
        System.out.println("현재 잔액: " + account + "원");
    }

    // 외부에서 계좌 번호(id)를 확인할 수 있게 해주는 Getter 메서드
    public int getId() {
        return id;
    }

    // 클래스 수준에서 현재 생성된 총 계좌 수를 반환하는 정적 메서드
    public static int getCount() {
        return count;
    }
}