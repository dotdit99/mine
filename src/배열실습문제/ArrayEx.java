package 배열실습문제;

import java.util.Scanner;

public class ArrayEx {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // ===================== 핸드폰 요금 =====================

        // 통화 시간을 저장할 배열 생성 (최대 20개)
        int callList[] = new int[20];
        // 영식 요금제 총 요금
        int yPay = 0;
        // 민식 요금제 총 요금
        int mPay = 0;

        // 통화 횟수 입력 안내
        System.out.print("통화 횟수: ");
        // 통화 횟수 입력받기
        int callCount = scanner.nextInt();
        // 통화 시간 입력 안내
        System.out.print("통화 시간: ");
        // callCount만큼 반복하며 통화 시간 입력받기
        for (int i = 0; i < callCount; i++) {
            // 입력받은 통화 시간을 callList[i]에 저장
            callList[i] = scanner.nextInt();
        }
        // callCount만큼 반복하며 요금 계산
        for (int i = 0; i < callCount; i++) {
            // 영식 요금제: 30초마다 10원 누적
            yPay += (callList[i] / 30) * 10 + 10;
            // 민식 요금제: 60초마다 15원 누적
            mPay += (callList[i] / 60) * 15 + 15;
        }
        // 영식 요금제가 더 비싸면
        if (yPay > mPay) {
            // 민식 요금제 출력
            System.out.println("M " + mPay);
            // 민식 요금제가 더 비싸면
        } else if (yPay < mPay) {
            // 영식 요금제 출력
            System.out.println("Y " + yPay);
            // 두 요금제가 동일하면
        } else {
            // 둘 다 출력
            System.out.println("Y M " + yPay);
        }

        // ===================== 저항 =====================

        // 색 이름 배열 (인덱스 = 저항 값)
        String colorNames[] = {"black", "brown", "red", "orange", "yellow",
                "green", "blue", "violet", "grey", "white"};
        // 곱 값 배열 (룩업 테이블)
        int colorMul[] = {1, 10, 100, 1000, 10000,
                100000, 1000000, 10000000, 100000000, 1000000000};

        // 버퍼 클리어 (nextInt() 후 nextLine() 사용 전)
        scanner.nextLine();
        // 첫 번째 색 입력 안내
        System.out.print("첫 번째 색: ");
        // 첫 번째 색 입력받기
        String firstColor = scanner.nextLine();
        // 두 번째 색 입력 안내
        System.out.print("두 번째 색: ");
        // 두 번째 색 입력받기
        String secondColor = scanner.nextLine();
        // 세 번째 색 입력 안내
        System.out.print("세 번째 색: ");
        // 세 번째 색 입력받기
        String thirdColor = scanner.nextLine();

        // 첫 번째 색의 저항 값
        int firstVal = 0;
        // 두 번째 색의 저항 값
        int secondVal = 0;
        // 세 번째 색의 곱 값
        int thirdVal = 0;

        // 색 배열을 순회하며 입력한 색과 일치하는 값 찾기
        for (int i = 0; i < colorNames.length; i++) {
            // 첫 번째 색과 일치하면 인덱스를 firstVal에 저장
            if (colorNames[i].equals(firstColor))  firstVal  = i;
            // 두 번째 색과 일치하면 인덱스를 secondVal에 저장
            if (colorNames[i].equals(secondColor)) secondVal = i;
            // 세 번째 색과 일치하면 곱 값을 thirdVal에 저장
            if (colorNames[i].equals(thirdColor))  thirdVal  = colorMul[i];
        }

        // 저항값 계산 후 출력 (firstVal, secondVal을 자릿수로 붙이고 곱 값 적용)
        System.out.println("저항값: " + (long)(firstVal * 10 + secondVal) * thirdVal + " 옴");
        scanner.close();
    }
}