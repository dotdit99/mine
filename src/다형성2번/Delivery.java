package 다형성2번;

import java.util.Scanner;

// 모든 배송 수단의 공통 분모가 되는 부모 클래스를 정의합니다.
public class Delivery {
    // 모든 배송 객체가 공통으로 가질 '회사 이름' 변수입니다.
    String company;

    // 객체 생성 시 회사 이름을 전달받아 내부에 저장하는 생성자입니다.
    public Delivery(String company) {
        this.company = company;
    }

    // 배송을 시작한다는 기본 동작입니다. 자식들이 이를 재정의(Override)할 것입니다.
    void deliver() {
        System.out.println("배송을 시작합니다.");
    }

    // 저장된 회사 이름을 안전하게 반환해 주는 도우미 메서드입니다.
    public String getCompany() {
        return company;
    }
}

// ---------------------------------------------------------

// 배송 업무를 총괄하고 프로그램을 실행하는 관리자 클래스입니다.
class Manager {
    // 매니저의 이름을 저장하는 변수입니다.
    String name;

    // 매니저 객체를 만들 때 이름을 등록하는 생성자입니다.
    public Manager(String name) {
        this.name = name;
    }

    // [다형성의 핵심] Delivery 타입이면 택배, 퀵, 항공 무엇이든 이 메서드로 들어올 수 있습니다.
    void send(Delivery d) {
        // d.getCompany()는 어떤 자식 객체가 들어오든 그 객체의 회사명을 출력합니다.
        System.out.println(name + " 매니저가 " + d.getCompany() + " 배송을 진행합니다.");

        // [동적 바인딩] d가 실제로 택배인지 퀵인지에 따라 그에 맞는 deliver()가 실행됩니다.
        d.deliver();
    }

    // 프로그램이 실제로 돌아가기 시작하는 시작 지점(Main 메서드)입니다.
    public static void main(String[] args) {
        // 홍길동이라는 이름을 가진 매니저 객체를 생성합니다.
        Manager manager = new Manager("홍길동");
        // 사용자로부터 번호를 입력받기 위한 스캐너를 준비합니다.
        Scanner sc = new Scanner(System.in);

        // 사용자가 종료를 선택하기 전까지 계속 메뉴를 보여주는 무한 루프입니다.
        while (true) {
            System.out.print("\n배송 시스템 선택 [1]택배 [2]퀵 [3]항공 [4]종료 : ");
            int choice = sc.nextInt();

            // 4번을 누르면 반복문을 빠져나가 프로그램을 끝냅니다.
            if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 사용자의 선택에 따라 각기 다른 배송 객체를 생성하여 매니저에게 전달합니다.
            switch (choice) {
                case 1:
                    // CJ대한통운이라는 이름을 가진 '택배' 객체를 생성해 매니저의 send에 넣습니다.
                    manager.send(new ParcelDelivery("CJ대한통운"));
                    break;
                case 2:
                    // 쿠팡로켓배송이라는 이름을 가진 '퀵' 객체를 생성해 전달합니다.
                    manager.send(new QuickDelivery("쿠팡로켓배송"));
                    break;
                case 3:
                    // FedEx라는 이름을 가진 '항공' 객체를