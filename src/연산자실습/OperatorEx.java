package 연산자실습;
// 윤년 계산하기
// 1. 연도가 4로 나누어 떨어짐 (4의 배수)
// 2. 100으로 나누어 떨어지면 윤년이 아님 (4의 배수이고 100의 배수가 아님)
// 3. 400으로 나누어 떨어지면 윤년임

// [100의 자리 정수 나누어 대입]
// 정수 입력: 649
// 100의 자리 정수: 6
// 10의 자리 정수: 4
// 1의 자리 정수: 9
// 이중 가장 큰 수 출력

import java.util.Scanner;

public class OperatorEx {
    public static void main(String[] args) {
        // 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);
        // 년도 입력 받기
        System.out.print("연도를 입력하세요: ");
        int year = scanner.nextInt();

        // 윤년 판별하기
        // 4의 배수이고 100의 배수가 아닌 수 or 400으로 나누어 떨어지는 수
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        {
            System.out.println(year + "년은 윤년입니다.");
        }else {
            System.out.println(year + "년은 윤년이 아닙니다.");
        }

        System.out.print("100의 자리 정수를 입력하세요: ");
        int num1 = scanner.nextInt();
        int hundred = num1 / 100;
        // 641이면 나누기 10으로 몫이 64 나옴 64를 다시 10으로 나누면 나머지 4가 나오면서 10의 자리인 수가 구해짐
        int ten = (num1 / 10) % 10;
        // 1의 자리는 10으로 나누지 못 하니 나머지 그대로 나옴 그게 1의 자리 수
        int one = num1 % 10;
        System.out.println("정수 입력: " + num1);
        System.out.println("100의 자리 정수: " + hundred);
        System.out.println("10의 자리 정수: " + ten);
        System.out.println("1의 자리 정수: " + one);

        /* 중첩 삼항 연산자를 이용한 최댓값 결정
         * 1단계: hundred와 ten 비교
         * 2단계: 1단계 승자와 one을 비교하여 최종 max 확정
         */
        // (조건1) ? (조건2 ? 참 : 거짓) : (조건3 ? 참 : 거짓); 은 중첩 삼항 연산자
        int max = (hundred > ten) ? (hundred > one ? hundred : one) : (ten > one ? ten : one);
        System.out.println("가장 큰 수는 " + max+ " 입니다.");

//        if (hundred > ten) {
//            // [참의 영역] 백이 십보다 클 때 들어옵니다.
//            if (hundred > one) {
//                max = hundred; // 백이 일보다도 크면 최종 승자는 백!
//            } else {
//                max = one;     // 백이 일보다 작으면 최종 승자는 일!
//            }
//        } else {
//            // [거짓의 영역] 백이 십보다 작거나 같을 때 들어옵니다.
//            if (ten > one) {
//                max = ten;     // 십이 일보다 크면 최종 승자는 십!
//            } else {
//                max = one;     // 십이 일보다 작으면 최종 승자는 일!
//            }
//        }
        // 연산자 우선 순위 확인
        int val1 = 5, val2 = 5, val3 =5;
        int rst1 = val1 + val2 * val3; // 곱셈과 나눗셈은 더하기 빼기보다 우선순위가 높음
        int rst2 = (val1 + val2) * val3; // 작은 괄호는 연산자 우선순위가 가장 높음
        int rst3 = val1+ (++val2) * val3; // 값 증가 후 곱셈, 덧셈 수행
    }
}
