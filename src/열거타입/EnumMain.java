package 열거타입;

// 열거타입(Enum): 한정된 상수 집합, 강력한 타입 제한 기능을 가짐

public class EnumMain {
    public static void main(String[] args) {
        Developer developer = new Developer("홍길동", DevType.BACKEND, Career.JUNIOR, Gender.MALE);
        developer.printInfo();
    }
}

