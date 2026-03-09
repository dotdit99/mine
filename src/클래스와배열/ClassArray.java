package 클래스와배열;

import java.util.Scanner;

public class ClassArray {
    public static void main(String[] args) {
        Student students[] = new Student[5];
        Scanner sc = new Scanner(System.in);
        // 학생 정보 입력
        for (int i = 0; i < students.length; i++){
            System.out.printf("[%d 번째 학생 정보 입력 ]\n", i +1);
            System.out.print("학번 : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("이름: ");
            String name = sc.nextLine();
            System.out.print("국어: ");
            int kor = sc.nextInt();
            System.out.print("영어: ");
            int eng = sc.nextInt();
            System.out.print("수학: ");
            int mat = sc.nextInt();
            // Student 클래스에 대한 객체 생성 후 배열에 대입
            students[i] = new Student(id, name, kor, eng, mat);
        }

        // 학생 정보 출력
        System.out.println("-".repeat(40));
        System.out.println(" 학번  이름  국어  영어  수학   총점  평균");
        System.out.println("-".repeat(40));
        for (Student e : students) e.printStudent();
        System.out.println("-".repeat(40));
    }
}
