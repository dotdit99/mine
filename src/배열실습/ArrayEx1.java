package 배열실습;

// 실습 문제 1 hamburgerEX()
// 햄버거 3개와 음료 2개의 가격을 입력 받기 (5개의 가격을 연속으로 입력 받음)
// 세트 메뉴 가격 = (햄버거 3개 중 가장 싼 메뉴 가격 + 음료 2개 중 싼 메뉴 가격) - 50(세트 할인)

// 실습 문제 2 evenOddx()
// 8개의 정수를 입력받아 배열에 저장
// 홀수는 홀수 배열에 나누어 담고 짝수는 짝수 배열에 나누어 담아서 출력하기

import java.util.Scanner;

public class ArrayEx1 {
    public static void hamburgerEX() {
        Scanner scanner = new Scanner(System.in);
        evenOddx(scanner);
        //문제 1
        // 가격 5개를 저장할 배열 생성
        int price[] = new int[5];
        // 입력 안내 문구 출력
        System.out.print("햄버거 3개 음료 2개 가격 입력: ");
        // i를 0부터 4까지 반복
        for (int i = 0; i < price.length; i++) {
            // 키보드로 입력받은 가격을 price[i]에 저장
            price[i] = scanner.nextInt();
        }

        // 햄버거 첫 번째 가격을 일단 최솟값으로 가정
        int minBurger = price[0];
        // i를 1부터 2까지 반복 (햄버거 범위 0~2)
        for (int i = 1; i < 3; i++) {
            // 현재 값이 최솟값보다 작으면
            if (price[i] < minBurger) {
                // 최솟값 교체
                minBurger = price[i];
            }
        }

        // 음료 첫 번째 가격을 일단 최솟값으로 가정
        int minDrink = price[3];
        // 음료 두 번째 가격이 더 작으면
        if (price[4] < minDrink) {
            // 최솟값 교체
            minDrink = price[4];
        }

        // 햄버거 최저가 + 음료 최저가 - 50(세트 할인) 계산
        int setPrice = minBurger + minDrink - 50;
        // 세트 메뉴 가격 출력
        System.out.println("세트 메뉴 가격: " + setPrice);
        }

        static void evenOddx(Scanner scanner){

        // 문제 2
        // 정수 8개를 저장할 배열 생성
        int num[] = new int[8];

        // i를 0부터 7까지 반복
        for (int i = 0; i < num.length; i++) {
            // 키보드로 입력받은 정수를 num[i]에 저장
            num[i] = scanner.nextInt();
        }

        // 홀수를 저장할 배열 생성 (크기 8)
        int num1[] = new int[num.length];
        // 짝수를 저장할 배열 생성 (크기 8)
        int num2[] = new int[num.length];
        // num1에 값을 저장할 위치 (홀수 개수 카운트)
        int oddCount = 0;
        // num2에 값을 저장할 위치 (짝수 개수 카운트)
        int evenCount = 0;

        // num 배열을 처음부터 끝까지 순회
        for (int i = 0; i < num.length; i++) {
            // num[i]를 2로 나눈 나머지가 0이 아니면 홀수
            if (num[i] % 2 != 0) {
                // 홀수를 num1의 oddCount번째 칸에 저장
                num1[oddCount] = num[i];
                // 다음 저장 위치로 한 칸 이동
                oddCount++;
            } else {
                // 짝수를 num2의 evenCount번째 칸에 저장
                num2[evenCount] = num[i];
                // 다음 저장 위치로 한 칸 이동
                evenCount++;
            }
        }

        // "홀수: " 텍스트 출력
        System.out.print("홀수: ");
        // 실제 홀수가 저장된 개수만큼만 반복
        for (int i = 0; i < oddCount; i++) {
            // num1의 i번째 홀수 출력
            System.out.print(num1[i] + " ");
        }

        // 줄바꿈 후 "짝수: " 텍스트 출력
        System.out.print("\n짝수: ");
        // 실제 짝수가 저장된 개수만큼만 반복
        for (int i = 0; i < evenCount; i++) {
            // num2의 i번째 짝수 출력
            System.out.print(num2[i] + " ");
        }
    }
}
