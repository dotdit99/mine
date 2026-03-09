package 다차원배열;

// 5명에 대한 학번, 국어, 영어, 수학 성적을 입력 받기
// 각 학생의 학번, 국어, 영어, 수학, 총점, 평균을 출력하기

import java.util.Scanner;

public class DoubleArray {
    public static void main(String[] args) {
        int students[][] = new int[5][5]; // 5명 학생 (학번, 국어, 영어, 수학, 총점)
        double avg[] = new double[5]; // 5명 학생에 대한 평균 구하기 (데이터 타입이 달라서 배열을 별도로 생성해야 함)
        Scanner sc = new Scanner(System.in);
        // 2차원 배열에 학번과 성적 입력 받기
        for (int i = 0; i < students.length; i++) { // 행에 대한 길이까지 반복 수행, 각 학생
        System.out.printf("[%d 번째 학생]\n",i + 1);
        System.out.print("학번 입력: ");
        students[i][0] = sc.nextInt(); // 학번
        System.out.print("국어 영어 수학 성적 : ");
            students[i][1] = sc.nextInt(); // 국어
            students[i][2] = sc.nextInt(); // 영어
            students[i][3] = sc.nextInt(); // 수학
            students[i][4] = students[i][1] + students[i][2] + students[i][3]; // 총점
            avg[i] = (double) students[i][4] / 3; // 평균
        }

        // 출력
        System.out.println("-".repeat(32));
        System.out.println("학번   국어   영어   수학   총점   평균");
        System.out.println("-".repeat(32));
        for (int i = 0; i < students.length; i++){
            System.out.printf("%4d %5d %5d %5d %6d %6.2f\n",
                    students[i][0], students[i][1], students[i][2], students[i][3], students[i][4], avg[i]);
        }
        System.out.println("-".repeat(32));
    }
}
