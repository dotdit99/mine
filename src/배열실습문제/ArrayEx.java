package 배열실습문제;

// 알고리즘 문제풀이 > 3단계 중급 문제 > 핸드폰 요금
// 알고리즘 문제풀이 > 3단계 중급 문제 > 저항

import java.util.Scanner;

public class ArrayEx {
    public static void main(String[] args) {
        // 핸드폰 요금
        Scanner scanner = new Scanner(System.in);
        //int call[] = new int[20];
        //int yPay = 0;
        //int mPay = 0;
        ////동호가 저번 달에 이용한 통화의 개수 N이 주어진다.
        //System.out.print("통화 횟수: ");
        //int n = scanner.nextInt();
        //// N은 20보다 작거나 같은 자연수이다. 둘째 줄에 통화 시간 N개가 주어진다.
        //// 통화 시간은 10,000보다 작거나 같은 자연수이다.
        //System.out.print("통화 시간: ");
        //for (int i = 0; i < n; i++){
        //    call[i] = scanner.nextInt();
        //}
        //for (int i = 0; i < n; i++){
        //    yPay += (call[i] / 30) * 10 + 10;
        //    mPay += (call[i] / 60) * 15 + 15;
        //}
        //if (yPay > mPay){
        //    System.out.println("M "+ mPay);
        //} else if (yPay < mPay) {
        //    System.out.println("Y "+yPay);
        //}else {
        //    System.out.println("Y M " + yPay);
        //}


        // 저항
        String colors[] = {"black", "brown", "red", "orange", "yellow",
                "green", "blue", "violet", "grey", "white"};
        System.out.print("첫 번째 색: ");
        String color1 = scanner.nextLine();
        System.out.print("두 번째 색: ");
        String color2 = scanner.nextLine();
        System.out.print("세 번째 색: ");
        String color3 = scanner.nextLine();

        int val1 = 0, val2 = 0, mul = 0;

        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(color1)) val1 = i;  // 첫 번째 색 → 값
            if (colors[i].equals(color2)) val2 = i;  // 두 번째 색 → 값
            if (colors[i].equals(color3)) mul = i;   // 세 번째 색 → 제곱수
        }

        // 첫 번째, 두 번째 값을 자릿수로 붙이고 곱 적용
        int resistance = (val1 * 10 + val2) * (int) Math.pow(10, mul);
        System.out.println("저항값: " + resistance + " 옴");

        // 룩업 테이블 저항
        String colors[] = {"black", "brown", "red", "orange", "yellow",
                "green", "blue", "violet", "grey", "white"};
        int mul[] = {1, 10, 100, 1000, 10000,
                100000, 1000000, 10000000, 100000000, 1000000000};

        System.out.print("첫 번째 색: ");
        String color1 = scanner.nextLine();
        System.out.print("두 번째 색: ");
        String color2 = scanner.nextLine();
        System.out.print("세 번째 색: ");
        String color3 = scanner.nextLine();

        int val1 = 0, val2 = 0, tVal = 0;

        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(color1)) val1 = i;       // 첫 번째 색 → 값
            if (colors[i].equals(color2)) val2 = i;       // 두 번째 색 → 값
            if (colors[i].equals(color3)) tVal = mul[i];  // 세 번째 색 → 곱 값 바로 꺼냄
        }

        System.out.println("저항값: " + (long)(val1 * 10 + val2) * tVal + " 옴");
    }
}
    }
}
