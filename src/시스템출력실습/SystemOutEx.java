package 시스템출력실습;


public class SystemOutEx {
    public static void main(String[] args) {

        String name = "홍길동";
        int age = 25;
        String hobby = "게임, 독서";
        String word = "안녕하세요, 잘 부탁드립니다.";


        System.out.println("=".repeat(32));
        System.out.println("나를 소개합니다!");
        System.out.println("=".repeat(32));
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("취미: " + hobby);
        System.out.println("한마디: " + "\"" + word + "\"" );
        System.out.println("=".repeat(32));



        int americano = 4500, cafelatte = 5500, cheesecake = 6800;
        int total;
        String bill = "JAVA CAFE 영수증";
        System.out.println("=".repeat(32));
        System.out.printf("%-15s\n",bill);
        System.out.println("=".repeat(32));
        System.out.printf("%-15s %s %,5d원\n", "아메리카노", "2잔", 2 * americano);
        System.out.printf("%-15s %s %,5d원\n", "카페라떼", "1잔", cafelatte);
        System.out.printf("%-15s %s %,5d원\n", "치즈케이크", "1조각", cheesecake);
        System.out.println("-".repeat(32));
        System.out.printf("%-15s %,5d원\n", "합계", total = 2*americano + cafelatte + cheesecake);
        System.out.println("=".repeat(32));
        System.out.printf("%-15s\n", "감사합니다. 또 방문해 주세요!");


        System.out.println("=".repeat(32));
        System.out.println("\t구구단");
        System.out.println("=".repeat(32));
        for (int i = 1; i <=9; i++){
            System.out.printf("%d x %d = %2d\n", 3, i, i * 3);
        }


    }
}
