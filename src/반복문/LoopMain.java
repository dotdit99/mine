package 반복문;

// 반복문: 주어진 조건이 참인 경우 혹은 주어진 횟수 만큼을 반복적으로 프로그램을 수행
// while 문: 반복 횟수를 알 수 없을 때 주로 사용
// do ~ while 문: 무조건 한번 수행 후 조건 비교
// for 문(초기값; 최종값; 증감값): 주어진 횟수를 반복
// Enhanced for 문: 배열이나 컬렉션과 같은 반복 가능한(iterable) 객체를 간편하게 순회할 때 사용, 내부값 변경 불가, 자동 순회


import java.util.Scanner;

public class LoopMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int num = sc.nextInt();
        int sum = 0; // 값을 누적하기 위한 변수, 반드시 초기화가 필요
        //while ( num > 0 ){ // 자바는 조건의 결과 true/false 이어야 함, 참인 경우 반복 수행
        //    sum += num; // sum = sum + num
        //    num--; // 반복문을 탈출하기 위한 조건 변경
        //
        //}

        //for ( int i = 1; i <= num; i++){
        //    sum += i;
        //}
        while (true){ // 무한 반복문
            sum += num;
            num--;
            if (num ==0) break; // 탈출 조건
        }
        System.out.println("누적 합계: " + sum);
    //
    }
}
