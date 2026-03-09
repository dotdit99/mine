package 클래스와배열;

import java.util.Scanner;

public class Student {
    int studentId; // 학번
    String name;
    int score[] = new int[3]; // 국어 영어 수학
    int total;
    double avg;

    // 생성자: 클래스 이름과 동일, 반환 타입이 없음, 인스턴스 필드 초기화, 클래스가 객체로 만들어 질 때 호출
    Student (int id, String name, int kor, int eng, int mat){
        this.studentId = id;
        this.name = name;
        this.score[0] = kor;
        this.score[1] = eng;
        this.score[2] = mat;
        this.total = kor + eng + mat;
        this.avg = (double) total / 3;
    }

    //void inputStudent(){
    //    Scanner sc = new Scanner(System.in);
    //
    //}
    void printStudent(){
        System.out.printf("%4d %-6s %5d %5d %5d %6d %6.2f\n",
                studentId, name, score[0], score[1], score[2], total, avg);
    }
}

