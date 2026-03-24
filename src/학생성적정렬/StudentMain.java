package 학생성적정렬;

import java.util.Scanner;
import java.util.TreeSet;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Student> students = new TreeSet<Student>();
        System.out.print("학생 수 입력: ");
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print("이름, 국어, 영어, 수학 점수 입력: ");
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int mat = sc.nextInt();
            students.add(new Student(name, kor, eng, mat));
        }

        // ✅ 수정 3: 출력 코드 추가
        System.out.println("\n[결과]");
        System.out.println("이름\t총점");
        for (Student s : students) {
            System.out.println(s.name + "\t" + s.getTotal());
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int kor, eng, mat;

    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public int getTotal() {
        return kor + eng + mat;
    }

    @Override
    public int compareTo(Student o) {
        if (this.getTotal() != o.getTotal())
            return o.getTotal() - this.getTotal(); // 양수 값이 나오면 정렬 조건, 큰 값이 앞으로 와야 함
        
        return this.name.compareTo(o.name);        // ASCII 기준으로 오름차순
    }
}