package While문실습;

// 이름은 문자열로 입력
// 나이는 정수로 입력 받는데 0에서 부터 199까지는 정상 입력, 나머지 수는 "나이 입력이 잘못 되었습니다." 재 입력 받기
// 성별은 문자로 입력, 'M', 'm', 'F', 'f' 만 정상 입력으로 간주하고 다른 문자이면 "성별 입력이 잘못 되었습니다." 재 입력 받기
// 직업은 정수로 입력 [1]회사원 [2]학생 [3]주부 [4]무직, 1 ~ 4 사이의 값이 아니면 "직업 입력이 잘못 되었습니다" 재 입력 받기
// 출력은 "회사원", "학생", "주부", "무직"
// 모든 입력이 정상적으로 입력되면 출력하기

import java.util.Scanner;

public class WhileEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        int age;
        char gender;
        String job[] = {"", "회사원","학생","주부","무직"};
        //int job2;
        int jobNum;
        while (true){
            System.out.print("나이를 입력하세요: ");
            age = scanner.nextInt();
            if (age >= 0 && age < 200) break;
            System.out.println("나이 입력이 잘못 되었습니다.");
        }
        while (true){
            System.out.print("성별을 입력하세요: [m / f] ");
            gender = scanner.next().toLowerCase().charAt(0); //소문자로 변경
            if ( gender == 'm' || gender == 'f') break;
            System.out.println("성별 입력이 잘못 되었습니다.");
        }
        String genderStr = (gender == 'm') ? "남성" : "여성";
        while (true) {
            System.out.print("번호를 입력하세요: [1]회사원 [2]학생 [3]주부 [4]무직 ");
            jobNum = scanner.nextInt();
            if (jobNum >= 1 && jobNum <= 4) break;
            System.out.println("번호 입력이 잘못 되었습니다.");

            //while (true){
            //System.out.print("번호를 입력하세요: [1]회사원 [2]학생 [3]주부 [4]무직 ");
            //char jobTmp = scanner.next().charAt(0);
            //if (Character.isDigit(jobTmp)){  // 숫자로 변환 가능한지 확인
            //job2 = (int) jobTmp - '0'; // ASCII 코드값으로 계산
            //if (job2 >= 1 && job2 <= 4) break;
            //System.out.println("직업 선택 코드가 잘못되었습니다.");
            //}else{
            //System.out.println("직업 코드는 숫자로 입력하세요.");
            //}


        }
        System.out.println("=".repeat(32));
        System.out.println("당신의 이름은 "+ name + " 나이는 " + age + " 성별은 " + genderStr + " 직업은 "+job[jobNum] + " 입니다.");
        System.out.println("=".repeat(32));
    }
}