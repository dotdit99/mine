package 더블for문;

// 2중 for문은 반복문 내에 반복문이 존재하는 것(행렬)

import java.util.Scanner;

public class DoubleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 키보드를 통해서 입력 받기 위해서 객체 스캐네 객체 생성
        //System.out.print("정수 입력: ");
        //int num = sc.nextInt();
        //// 입력 받은 정수 * 정수 만큼의 별 찍기
        //for (int i = 0; i < num; i++){ // 행을 의미함
        //    System.out.printf("|i=%2d|",i); // i 값의 변화를 확인 위한 출력
        //    for (int j=0; j < num; j++){
        //        System.out.print("* "); // 별을 찍고 공백을 줌
        //    }
        //    System.out.println(); // 한줄을 출력 후 줄바꿈을 함
        //
        //}
        
        // 구구단 출력하기: 단(2 ~ 9) * 1 ~ 9
        for (int i = 2; i <= 9; i++){ // 단
            System.out.printf("[ %d단 ]\n",i);
            for (int j=1; j<= 9; j++){
                System.out.printf("%2d * %2d = %2d\n",i ,j, i * j);
            }
            System.out.println("-".repeat(32));
        }

    }
}
