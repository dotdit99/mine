package 조건문;

/*
   제어문: 조건문과 반복문 있음, 프로그램의 순차적인 흐름을 제어하기 위함
   조건문: 주어진 조건식의 결과에 따라 조건 분기 후 실행
   반복문: 주어진 조건이 참인 동안 반복 수행
*/


/*  조건문의 종류
    if, if ~ else, if ~ else if else: 조건식을 이용해 조건 분기, 모든 경우에 사용 가능
    switch ~ case: 조건값에 의한 분기, 정수값, 문자, 문자열, 실수값은 안됨
    3항 연산자: 참과 거짓만 분기할 때 사용, 연산자이기 때문에 출력 구문 내에서 사용 가능
 */

import java.util.Scanner;

public class ConditionMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int num = sc.nextInt();
        // 정수값 입력 받음
        sc.nextLine(); // 버퍼 정리ㄱ
        if (num > 100 ){ // 조건식이 참인 경우 수행
            System.out.println(num+"은 100보다 커요.");
        }else if(num < 100){
            System.out.println(num + "은 100보다 작아요.");
        }else{
            System.out.println(num + "은 100입니다.");
        }


        // 이름, 국어, 영어, 수학 성적을 입력받기
        // 각각의 성적이 0 ~ 100 사이가 아니면 "성적 입력 오류" 출력 후 종료
        // 성적이 제대로 입력 되면 총점과 평균 구하기
        //평균이 90점 이상이면 이름, 총점, 평균, 등급: A
        //평균이 80점 이상이면 이름, 총점, 평균, 등급: B
        //평균이 70점 이상이면 이름, 총점, 평균, 등급: C
        //평균이 60점 이상이면 이름, 총점, 평균, 등급: D
        //평균이 60점 미만이면 이름, 총점, 평균, 등급: F
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();

        System.out.print("국어 점수를 입력하세요: ");
        int kor = sc.nextInt();
        System.out.print("영어 점수를 입력하세요: ");
        int eng = sc.nextInt();
        System.out.print("숫자 점수를 입력하세요: ");
        int math = sc.nextInt();
        double avg = (double) (kor + eng + math) / 3;
        char grade; // 등급을 결정할 문자열 변수 생성
        int total = kor + eng + math;
        if (kor < 0 || kor > 100 || eng < 0 || eng > 100 || math < 0 || math > 100) {
            System.out.println("성적 입력 오류");
            return; // main() 메서드의 실행 결과 반환
        }
        if (avg >= 90) grade = 'A';
        else if (avg >= 80) grade = 'B';
        else if (avg >= 70) grade = 'C';
        else if (avg >= 60) grade = 'D';
        else grade = 'F';

        System.out.printf("이름은 %s, 총점은 %d, 평균은 %.2f, 등급은 %c 입니다.\n", name, total, avg, grade);

        //if (avg  >= 90) {
        //    System.out.println("이름: " + name + " 총점: " + total + " 평균: " + avg + " 등급: A");
        //}else if (avg  >= 80) {
        //    System.out.println("이름: " + name + " 총점: " + total + " 평균: " + avg + " 등급: B");
        //}else if (avg  >= 70) {
        //    System.out.println("이름: " + name + " 총점: " + total + " 평균: " + avg + " 등급: C");
        //}else if (avg  >= 60) {
        //    System.out.println("이름: " + name + " 총점: " + total + " 평균: " + avg + " 등급: D");
        //}else{
        //    System.out.println("이름: " + name + " 총점: " + total + " 평균: " + avg + " 등급: F");
        //}

    }
}
