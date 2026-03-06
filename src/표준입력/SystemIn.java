package 표준입력;

import java.util.Scanner;

public class SystemIn {
    public static void main(String[] args) {
        // 키보드를 통한 입력을 받기 위해 스캐너 클래스에 대한 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

//        byte a = sc.nextByte(); // 스캐너 객체를 통해서 byte 타입의 값을 입력 받아 a 변수에 대입
//        short b = sc.nextShort();
//        int c = sc.nextInt();
//        long d = sc.nextLong();
//        float e = sc.nextFloat();
//        double f = sc.nextDouble();
//
//        // 문자와 문자열
//        String name = sc.next(); // 공백 기준으로 문자열을 입력 받음
//        String addr = sc.nextLine(); // 줄바꿈 기준으로 문자열을 입력 받음
//        char ch = sc.next().charAt(0); // 문자열에서 맨앞의 문자 추출

        // 이름은 next()
        // 주소는 nextLine()
        // 성별은 next().charAt(0); 'M'/'F'로 입력 받아서 출력은 "남성", "여성" 출력
        // 직업은 [1]회사원 [2]학생 [3]주부 [4] 무직: 정수로 입력 받아서 문자열로 출력
        // 나이 nextInt() 입력
        // 입력 완료시 결과 출력

        System.out.print("이름을 입력하세요: ");
        String name = sc.next();
        // (엔터 잡아먹기) / 버퍼 비우기, 안 넣으면 다음줄에 영향을 줘버림
        sc.nextLine();
        System.out.print("주소를 입력하세요: ");
        String addr = sc.nextLine();

        System.out.print("성별을 입력하세요: ");
        char gender = sc.next().toUpperCase().charAt(0); //.toUpperCase() 대문자로 변경


        String[] jobs = {"회사원", "학생", "주부", "무직"};
        System.out.print("번호를 입력하세요: ");
        int job = sc.nextInt();

        System.out.println("이름: "+name +"입니다.");
        System.out.println("주소: "+addr+"입니다.");
        if (gender  == 'M') {
            System.out.println("성별: 남성입니다.");
        } else {
            System.out.println("성별: 여성입니다.");
        }
        System.out.println("선택하신 직업은: " + jobs[job] +"입니다.");
        //




    }
}
