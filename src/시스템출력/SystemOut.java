package 시스템출력;
// 자바 표준 입출력 클래스: 사용자와 프로그램 사이의 입출력을 담당
// 입력과 출력은 무수히 많은 장치가 있을 수 있음
// System.in: 표준 입력 스트림, 사용자의 입력을 프로그램으로 넣는 것
// System.out: 표준 출력 스트림, 프로그램의 출력을 콘솔로 나타내는 것
// System.err: 표준 오류 스트림, 프로그램 내에서 발생한 오류를 콘솔에 출력할 떄 사용, 속도는 빠르지만 리다이렉션이 안됨

public class SystemOut {
    public static void main(String[] args) {
        // 표준 출력: println() 줄바꿈 포함, print() 줄바꿈 없음, printf("서식", 출력값) 서식 지정자 사용
        // 이름 문자열, 주소 문자열, 성별 문자, 국어 영어 수학 성적은 정수, 총점은 점수, 평균은 실수형 (형변환 필요)

        String name = "홍길동";
        String adr = "천안시 동남구";
        char gender = '남';
        int kor = 50, eng = 40, mat = 20;
        int total = kor + eng + mat;
        double avg = (double) (total) / 3;

        System.out.println(name);
        System.out.println(adr);
        System.out.println(gender);
        System.out.println(total);
        System.out.printf("%f\n", avg);

        // 이스케이프 시퀀스: 화면 출력 제어 (\n \r \t \n \\)
        System.out.println("안녕하세요");
        System.out.println(name + "님");
        System.out.println("딸기\r바나나\r키위"); // \r 커서를 맨 앞으로 돌릴 때 사용함 진행 몇 % 됐는지 업데이트 할 때 사용
        System.out.println("딸기\t바나나\t키위"); // tab 사이즈 만큼의 간격을 띄움
        System.out.println("딸기\b바나나\b키위"); // \b 앞의 한 글자를 지움
        System.out.println("딸기\\바나나\\키위"); // \\ \를 넣고 싶을 때 사용함 \ 1개만 쓰면 오류가 발생함

        // 서식지정자 사용
        System.out.printf("이름: %s\n", name); // 문자열 출력 서식은 %s, 변수를 서식에 대입해서 출력
        System.out.printf("주소: %s\n", adr);
        System.out.printf("성별: %c\n", gender); //문자 출력 서식은 %c
        System.out.printf("총점: %d\n", total); //정수 출력 서식은 %d
        System.out.printf("평균: %.2f\n", avg); // 실수 출력 서식은 %, %.2f 소수점 3번째 자리를 반올림하여 소수점 2자리까지 표시

        //println(), print(): 오버로딩: 동일한 이름의 메서드를 매개변수의 개수나 타입으로 호출할 메서드를 결정함
        System.out.println("이름: " + name); // 문자열 출력에 대한 메서드 호출
        System.out.println("주소: " + adr);
        System.out.println("성별: " + ((gender == 'M' ? "남성" : "여성"))); // 3항 연산자 사용 gender가 M이면 남성 출력 그렇지 않다면 여성 출력
        System.out.println("총점: " + total);
        System.out.println("평균: " + avg);

        System.out.println("JDK" + 17 + 8); // 앞에 문자열이 나오면 뒤에 숫자도 문자열로 간주함
        System.out.println(17 + 8 + "JDK"); // 앞에 정수가 나오면 정수 연산 하고서 문자열에 붙임


    }
}
