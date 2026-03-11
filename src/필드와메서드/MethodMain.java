package 필드와메서드;

import java.util.Scanner;

// 필드: 객체의 속성값을 저장 (인스턴스/정적 필드 등)
// 메서드: 객체의 동작을 구현. 자바는 모든 함수가 클래스 내부의 메서드 형태여야 함
public class MethodMain {
    // 프로그램의 시작점인 main 메서드 (Stack 영역에 프레임 생성됨)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("소수 판별 정수 입력: ");
        int num1 = scanner.nextInt();
        // Heap 영역에 Sample 객체를 생성하고, Stack 영역의 참조 변수 sample에 주소값 저장
        Sample sample = new Sample();

        // 생성된 객체의 sum 메서드 호출 및 결과 출력 (인자값 10, 20 전달)
        System.out.println(sample.sum(10, 20));

        // 반환값이 없는 void 메서드 호출
        sample.hello();

        // 문자열 반환 메서드 호출 및 결과 출력
        System.out.println(sample.rtnHello());

        // 필드 x, y의 합을 반환하는 메서드 호출
        System.out.println(sample.rtnNum());

        // 뺄셈 메서드 호출 (Stack에 sub 메서드 프레임 생성됨)
        System.out.println(sample.sub(100, 20));

        // 곱셈 메서드 호출
        System.out.println(sample.mul(100, 20));

        // 나눗셈 메서드 호출 (정수 연산 후 double 형변환 결과 출력)
        System.out.println(sample.div(100, 20));

        // 오버로딩: 가변 인자(int...)를 사용하는 sum 메서드 호출 (정수 3개)
        System.out.println(sample.sum(100, 200, 300));

        // 오버로딩: 문자열 3개를 연결하는 sum 메서드 호출
        System.out.println(sample.sum("안유진", "장원영", "이서"));

        // 오버로딩: 실수와 정수를 더하는 sum 메서드 호출
        System.out.println(sample.sum(100.23, 200));

        // 오버로딩: 문자열, 정수, 실수를 혼합하여 더하는 sum 메서드 호출
        System.out.println(sample.sum("JDK", 10, 3.14));

        // 가변 인자 오버로딩 호출: 1부터 10까지 전달 (nums 배열로 전달됨)
        System.out.println(sample.sum(1,2,3,4,5,6,7,8,9,10));

        // Stack 영역에 지역 변수 k 선언
        int k;
        {
            // 블록 내부에서 k 초기화
            k = 100;
            // 블록 내부에서 k 사용
            System.out.println(k);
        }
            // 입력 받은 수가 소수인지 아닌지 판별하는 메서드 만들기
            // "입력받은  수"는 소수입니다. "입력받은 수"는 소수가 아닙니다.
        // if문의 괄호 ( ) 안은 결국 '참(true)인지 거짓(false)인지'만 판별하는 자리이기 때문에,
        // 메서드 자체가 boolean 값을 반환한다면 별도의 비교 연산자가 필요 없습니다.
        System.out.println("입력받은 수는 " + num1 + ((sample.rtnPrimeNumber(num1)) ? " 소수입니다" : " 소수가 아닙니다."));
            // 블록 밖에서 선언된 k이므로 블록이 끝나도 생존하여 출력 가능
        System.out.println(k);

    } // main 메서드 종료 시 Stack 영역의 데이터 모두 소멸
}

class Sample {
    // 인스턴스 필드: Heap 영역에 객체와 함께 생성되며 객체 소멸 시 사라짐
    int x = 100;
    int y = 200;

    // 정적(static) 필드: Static 영역에 생성되며 프로그램 종료 시까지 유지됨 (공용 자원)
    static int z = 300;

    // 정수 2개를 더하는 인스턴스 메서드
    int sum(int x, int y) {
        return x + y;
    }

    // 오버로딩: 문자열 3개를 연결하는 메서드
    String sum(String x, String y, String z) {
        // 지역 변수: Stack 영역에 저장되며 메서드 종료 시 즉시 소멸
        int tmp = 1000;
        return x + y + z + tmp;
    }

    // 오버로딩: 실수와 정수를 연산하여 double 타입으로 반환
    double sum(double x, int y) {
        return x + y;
    }

    // 오버로딩: 문자열과 수치 데이터 연산 (괄호 안 연산 우선)
    String sum(String x, int y, double z) {
        return x + (y + z);
    }

    // 뺄셈 메서드
    int sub(int x, int y) {
        return x - y;
    }

    // 가변 인자(Varargs) 메서드: 전달된 인자들을 배열로 처리함
    int sum(int... nums) {
        // 지역 변수 sum 초기화
        int sum = 0;
        // 향상된 for문: 가변 인자 배열 nums를 처음부터 끝까지 순회
        for (int num : nums) {
            sum += num;
        }
        // 합계 반환
        return sum;
    }

    // 곱셈 메서드
    int mul(int x, int y) {
        return x * y;
    }

    // 나눗셈 메서드: 결과의 정확도를 위해 double로 형변환(Casting) 수행
    double div(int x, int y) {
        return (double) x / y;
    }

    // 반환값이 없는 알림 출력 메서드
    void hello() {
        System.out.println("안녕하세요~~~~");
    }

    // 고정된 환영 인사를 반환하는 메서드
    String rtnHello() {
        return "안녕하세요~~~~";
    }

    // 현재 객체의 필드 x, y 값을 더해 반환하는 메서드
    int rtnNum() {
        return x + y;
    }
    // 소수면 true, 소수가 아니면 false
    boolean rtnPrimeNumber(int num1) {
        if (num1 <= 1) return false; // 1과 같거나 작으면 소수가 아님
        for (int i = 2; i < num1; i++) {
            if (num1 % i == 0) {
                return false;
            }
        }
        return true;
    }
}