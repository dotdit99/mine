//package 접근제한자;
//
//// 접근제한자: 데이터 은닉을 위해서 사용(내부의 필드 값이 잘못 변경되는 걸 방지 하기 위해서 사용)
//// 게터와 세터 메서드: 데이터 은닉된 필드값을 읽고 쓰기 위해서 사용
//// public: 접근 제한이 없음 (클래스, 필드, 생성자, 메서드)
//// protected: 같은 패키지이거나, 다른 패키지에 있더라도 상속 관계가 존재하면 접근 가능 (필드, 생성자, 메서드)
//// default: 같은 패키지 내에서만 접근 가능 (키워드 없음) (클래스, 필드, 생성자, 메서드)
//// private: 같은 클래스 내에서만 접근 가능 (필드, 생성자, 메서드)
//
//public class PrivateMain {
//    public static void main(String[] args) {
//        Child child = new Child();
//        System.out.println(child.getName());
//        System.out.println(child.getAddress());
//        System.out.println(child.getMoney());
//    }
//
//    Parent parent = new Parent();
//
//}
//
//class Child extends Parent {
//
//}
