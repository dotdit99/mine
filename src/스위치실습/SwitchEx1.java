package 스위치실습;

// 좌변 값, 연산자, 우변값을 입력 받아 산술 연산(+ - * / %)을 수행하는 스위치문 만들기
// 입력: 23 + 45
// 출력: 68

import java.util.Scanner;

public class SwitchEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산식 입력: ");
        int left = scanner.nextInt();
            char sign = scanner.next().charAt(0);
        int right = scanner.nextInt();

        double result = 0;

        switch (sign){
            case '+':
                result = left + right;
                break;
            case '-':
                result = left - right;
                break;
            case '*':
                result = left * right;
                break;
            case '/':
                result = left / right;
                break;
            case '%':
                result = left % right;
                break;
            default:
                System.out.println("입력이 잘못되었습니다.");
                break;
        }

        System.out.printf("%.2f\n", result);

    }
}
