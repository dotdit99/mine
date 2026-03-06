package 변수와자료형;

import java.util.Scanner;

// 클래스 이름은 대문자로 시작 해야 함
public class DataTypeMain { // 파스칼 표기법
    public static void main(String[] args) {
        //int age; // 정수 타입의 값을 저장하기 위한 변수 선언, 4byte 메모리 공간을 확보 함
        // 변수란? 메모리 공간을 확보하고 이름을 붙이는 것
        // 자바에서는 JVM이 메모리 할당을 담당

        // 변수 이름 규칙
        // 1. 영문자, 숫자, _ &, 한글 가능
        // 2. 숫자가 먼저 나올 수 없음 int 1age;
        // 3. 자바의 키워드 사용하면 안됨 int if;
        // 4. 카멜 표기법 준수 int memberInfo;
        // 스네이크 표기법(C언어, Python)에서 사용하는 표기법 int member_info;
        // 5. 가장 중요한 것: 사용 목적에 맞게 이름을 지어야 함

        // 나이, 이름, 주소, 전화번호, 성인 여부 확인하는 변수 이름 작성하기
        int age = 23; // 4byte 정수 타입의 age 이름의 변수를 생성하고 23을 대입
        String name = "곰돌이사육사"; // 문자열 타입의 변수를 생성하고 "곰돌이사육사"라는 문자열의 주소를 대입
        String phone = "010-0000-0000";
        boolean isAdult = true; // 참과 거짓으로 값을 판별
        System.out.println("나이 : " + age);
        System.out.println("이름 : " + name);
        System.out.println("전화번호 : " + phone);
        System.out.println("성인 여부 : " + isAdult);

        // 자료형(Data Type): 저장할 데이터의 형태를 결정, 기본 자료형(소문자로 시작함)과 참조 자료형(대문자로 시작함)이 있음
        boolean isTrue;  // 1byte, true/false
        char gender = '가'; // 문자를 저장, 2byte, 부호가 없음, 내부적으로는 정수값이 사용됨, 문자는 '', 문자열은 ""
        System.out.println((int) gender);
        // 문자열은 참조 타입, "문자열"은 리터럴 상수로 취급됨
        String addr = "경기도 수원시";
        // Number 타입은 정수형과 실수형으로 나누어 짐
        // 정수형: byte(1), short(2), int(4), long(8) 소수점 이하가 없고 부호가 있음
        byte num1 = 127;
        // 실수형: float(4), double(8) 소수점 이하가 있고 부호가 있음, switch 문에서 비교값으로 사용할 수 없음
        float height = 1.7f; // 자정밀도 표현 방식이며 f포함해야 함
        double weight = 70.5; // 배정밀도 표현 방식이며 기본타입
        // 실수 표현 방식의 문제점: 연산 결과에 오차가 발생함(근사치 계산법)
        double num2 = 0.1;
        System.out.println(num2 + num2 + num2 + num2 + num2 + num2 + num2 + num2 + num2 + num2);
        // 상수(constant): 변수와 다른점은 값이 대입된 후 변경할 수 없음
        final double TAX_RATE; // 세율에 대한 상수 정의, 값이 대입된 이후 변경, 관례상 변수명은 대문자로 표시
        Scanner sc = new Scanner(System.in); // 키보드 입력을 받기 위한 스캐너 객체 생성
        System.out.print("수입을 입력하세요: "); // print() 줄바꿈을 하지 않음 ln=줄바꿈
        int income = sc.nextInt(); // 스캐너 객체로 부터 정수값을 입력 받아 income 변수에 대입
        TAX_RATE = 0.10;
        System.out.println("당신이 내야할 세금은 " + (income * TAX_RATE) + " 입니다.");

        // 형변환: 정해진 타입을 다른 타입으로 변환하는 것
        // 명시적 형변환: 개발자가 의도를 가지고 형을 변경하는 것
        // 묵시적 형변환: 컴파일러가 자동으로 유리한 방향으로 형을 변환하는 것
        int kor = 99, eng = 66, mat = 77;
        double avg = (kor + eng + mat) / 3.0; //(double) (kor + eng + mat) / 3 명시적, (kor + eng + mat) / 3.0 묵시적
        System.out.printf("%.2f\n", avg); //소수점 이하 3번째 자리에서 반올림에서 2번째 자리까지 표시

        // 타입 변환 메서드: 문자열을 정수나, 실수로 변환할 떄  사용하는 메서드
        String val1 = "0100.234";
        System.out.println(300 + Double.parseDouble(val1));

    }
}
