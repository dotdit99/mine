package 배열기본;

// 자바의 배열은 동일한 데이터 타입이 연속적으로 저장되는 자료 구조
// 배열은 여러 개의 값을 하나의 변수에 저장할 수 있도록 해주며, 인덱스를 사용해 각 요소에 접근 (인덱스는 0부터 시작)
// 자바의 배열은 기본 자료형과 객체 타입(참조형) 모두 사용 가능
// 자바의 배열은 객체로 취급되며, 기본적으로 Heap 영역에 메모리가 할당됨

import java.util.Scanner;

public class ArrayMain {
    public static void main(String[] args) {
        // 국어, 영어, 수학, 과학, 코딩 성적을 입력받아 총점과 평균 구하기
        int score[] = new int[5]; // 5과목에 대한 성적을 입력받기 위한 배열 생성
        Scanner sc = new Scanner(System.in);

        System.out.print("국어 영어 수학 과학 코딩 성적 입력: ");
        score[0] = sc.nextInt(); // 국어, 배열의 인덱스는 0부터 시작함
        score[1] = sc.nextInt(); // 영어
        score[2] = sc.nextInt(); // 수학
        score[3] = sc.nextInt(); // 과학
        score[4] = sc.nextInt(); // 코딩

        // 총점 구하기
        int total = 0;
        //for (int i = 0; i < score.length; i++){
        //    total += score[i]; // total = total + score[i], 해당 인덱스의 값을 가져와 누적
        //}
        // 향상된 for문, 이터러블 객체를 자동으로 순회, 배열 내부의 값을 변경할 수 없음, 무조건 처음부터 끝까지 순회
        for (int e : score){
            total += e; // total = total + e
        }
        double avg = (double)total / score.length;

        // 각 과목의 성적과 총점 평균 출력
        System.out.printf("%3d %3d %3d %3d %3d %4d %4.2f\n", score[0], score[1], score[2], score[3], score[4], total, avg);

    }
}
