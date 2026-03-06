package 연산자;

import java.util.Scanner;

// 연산자: 프로그램에서 사용하는 값을 연산해야 하는 경우에 사용
// 산술 연산자: 사칙연산과 나머지 연산(+, -, *, /, %)
// 대입 연산자: 변수에 값을 대입할 때 사용 (=, +=, -=, /=, %=)
// 증감 연산자: ++, --, 단항연산자 변수의 값을 1증가 혹은 1감소 시키는 연산자
// 비교 연산자: ==, >, <, >=, <=, !=, 좌변과 우변의 값을 비교하여 결과를 참과 거짓으로 판별함
// 논리 연산자: &&(and, 좌항과 우항을 모두 만족해야 참), ||(or, 좌항과 우항 둘 중 하나만 만족하면 참), !(not, 현재의 상태를 부정)
// 삼항 연산자: 참과 거짓만 있는 조건문을 만들 수 있음
// 비트 연산자: 비트 단위의 연산을 수행
public class OperatorMain {
    public static void main(String[] args) {
        int x=10, y=4;
        System.out.println(x+y);
        System.out.println(x-y);
        System.out.println(x*y);
        System.out.println(x/y); // 정수이기에 소수점을 날려 버려서 나누셈이 아닌 몫을 구하는 연산이 됨
        System.out.println((double) x/y); // 나눗셈을 하기 위한 명시적인 형변환
        System.out.println(x%y); // 나머지 연산자, 알고리즘에서는 산술연산자 중에서 나머지 연산자가 많이 사용됨


        // 대입 연산자
        int num1 = 10; // 정수 타입의  num1 변수에 10을 대입
        System.out.println(num1 += 2); // 복합 대입 연산자, num1 = num1 + 2
        System.out.println(num1 -= 2); // num1 = num1 - 2 = 10 위에서 2를 더해서 12가 되었기에
        System.out.println(num1 *= 2); // 20
        System.out.println(num1 /= 2); // 10
        System.out.println(num1 %= 2); // 0

        // 증감 연산자
        int num2 = 10;
        // ++(전위)변수명++(후위) 전위면 1증가시키고서 변수에 대입함 / 후위면 대입하고 나서 1증가시킴
        // --(전위)변수명--(후위) 전위면 1감소시키고서 변수에 대입함 / 후위면 대입하고 나서 1감소시킴
        System.out.println(num2++);
        System.out.println(num2);

        //비교 연산자
        int num3 = 10, num4 = 20;
        System.out.println(num3 == num4); // num3와 num4가 같지 않으니 거짓
        System.out.println(num3 != num4); // num3와 num4가 같지 않으니 참
        System.out.println(num3 > num4); // num3가 num4보다 크지 않으니 거짓
        System.out.println(num3 < num4); // num4가 num3보다 크니 참
        System.out.println(num3 >= num4); // num3가 num4보다 크거나 같지 않으니 거짓
        System.out.println(num3 <= num4); // num4가 num3보다 크거나 같으니 참

        // 논리 연산자
        int num5 = 10, num6 = 20;
        System.out.println(num5 > 0 && num5 > num6); // (AND)산술 연산자가 논리 연산자보다 우선순위가 높음, 거짓
        System.out.println(num5 > 0 || num5 > num6); // (OR)좌변이 참이기에 우변을 볼 필요도 없이 참
        System.out.println(!(num5 > 0 || num5 > num6)); //(NOT)참이기에 거짓

        // 3항 연산자 : 참과 거짓만 있는 조건문 대체
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 입력: ");
        int age = sc.nextInt(); //스캐너 객체로 부터 나이를 입력을 받음
//        if (age >= 18){
//            System.out.println("당신은 성인입니다");
//        }
//        else {
//            System.out.println("당신은 미성년자입니다.");
//        }

            System.out.println("당신은 " + (age >= 18 ? "성인" : "미성년자") + "입니다.");

    }
}
