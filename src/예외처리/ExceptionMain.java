package 예외처리;

// 예외처리: 프로그램의 비정상적인 상황을 감지해 적절한 예외 처리를 해서 정상적인 실행 상태를 유지하도록 하는 것
// checked 예외: 자바 컴파일러가 반드시 예외 처리를 확인 (예외 처리가 안되어 있으면 컴파일 오류 발생됨)
// unchecked 예외: 컴파일러가 예외 처리를 강제하지 않음(예외 처리를 하지 않아도 되지만 실행 중 예외가 발생하면 프로그램 중단됨)

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {
    // ✅ 1. throws 제거 (main 안에서 직접 처리하므로 불필요)
    public static void main(String[] args) {
        int[] arr = new int[5];

        try {
            for (int i = 0; i <= arr.length; i++) {
                arr[i] = i;
                System.out.print(arr[i] + " ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // System.out.println(e);
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0, rst = 0;
        System.out.println("나눗셈 계산기 입니다.");

        while (true) {

            try {
                System.out.print("첫번째 수 입력 : ");
                num1 = sc.nextInt();
                System.out.print("두번째 수 입력 : ");
                num2 = sc.nextInt();
                rst = num1 / num2;
                break; // ✅ 2. 정상 입력 시 루프 탈출 → 이후 코드 실행 가능
            } catch (ArithmeticException e) {
                System.out.println("나눗셈은 0으로 나눌 수 없습니다.");
            } catch (InputMismatchException e) {
                System.out.println("문자는 입력할 수 없습니다. 정수를 입력하세요.");
                sc.nextLine(); // 잘못된 입력 버퍼 비우기
            }
            System.out.println("연산 결과 : " + rst);
        }

        // 파일이 없는 경우
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("없는 파일"));
            br.readLine();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없거나 읽을 수 없습니다." + e);
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ignored) {
            }
        }
    } // ✅ main 닫기
} // ✅ class 닫기