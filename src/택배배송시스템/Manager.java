package 택배배송시스템;

// 배송 관리자 클래스
public class Manager {
    String name;
    public Manager(String name){
        this.name = name;
    }
    public void send(Delivery delivery){
        System.out.println(name + "매니저가 " +
                delivery.getCompany() + "회사의 배송을 지시 합니다.");
        delivery.deliver();
    }
}
