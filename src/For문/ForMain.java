package For문;

//for 문 조건이 true면 → 실행 false면 → 멈춤

import java.util.Scanner;

//for(초기값; 최종값; 증감값) {}
public class ForMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("정수 입력: ");
        //int num = scanner.nextInt();
        //
        //for(int i = 0; i < num; i++){
        //    System.out.print("* ");
        //}
        // 위 아래는 동일한 기능을 함
        /*
        int i = 0;
        for(;;){
        System.out.print(" * ");
        i++;
        if (i == num) break;}
        */
        //System.out.println();
        // 정수값을 입력 받음
        // 입력 받은 정수값 범위의 5의 배수 1줄에 10개씩 출력하기
        // int count = 0;
        // System.out.println("정수 입력: ");
        // b % 5 ==0 5의 배수
        //for (int b = 1; b <= num; b ++){
        //    if ( b % 5==0) {
        //        System.out.printf("%4d",b);
        //        count++; // b가 5의 배수라면 b를 출력하고 count 1 증가시킴
        //    }
        //    if (count % 10 == 0) {// count가 증가하다 10으로 나눠서 나머지가 0이 되면
        //        System.out.print("\n"); // 줄바꿈을 출력함
        //        count = 0; // count 초기화
        //    }
        //}
        // 정수 num을 입력받아 num * num 출력하기
        // 싱글 for문
        // 입력 3
        // 1 2 3
        // 4 5 6
        // 7 8 9
        //int count = 0;
        //for (int i = 1; i <= num * num; i++) {
        //    System.out.printf("%4d",i);
        //    count++;
        //    if (count % num == 0) {// count가 증가하다 10으로 나눠서 나머지가 0이 되면
        //        System.out.print("\n"); // 줄바꿈을 출력함
        //    }
        //}
        // 문자열을 입력 받아 역순으로 출력하기
        String str = scanner.nextLine();
        String rst = "";
        //조건이 true면 → 실행 조건이 false면 → 멈춤
        for (int a = str.length() - 1; a >= 0; a--) {
            rst += str.charAt(a);
        }
        System.out.println(rst);
        scanner.close();
    }
}


