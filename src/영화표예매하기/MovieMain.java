package 영화표예매하기;

import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {

        // 가격 10000원으로 MovieTicket 객체 생성
        MovieTicket movieTicket = new MovieTicket(10000);

        // 입력을 받기 위한 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 메뉴 기능 구현을 위해 무한 반복문
        while (true) {

            // 메뉴 이름 출력
            System.out.println("===== 영화표 예매 시스템 =====");
            System.out.println("1. 좌석 현황 보기");
            System.out.println("2. 예매하기");
            System.out.println("3. 취소하기");
            System.out.println("4. 총 판매 금액 확인");
            System.out.println("5. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int menu = scanner.nextInt();
            scanner.nextLine(); // nextInt() 후 버퍼 비우기

            switch (menu) {
                case 1:
                    movieTicket.printSeats();
                    break;
                case 2:
                    movieTicket.book();
                    break;
                case 3:
                    movieTicket.cancel();
                    break;
                case 4:
                    System.out.println("총 판매 금액: " + movieTicket.getTotalSales() + "원");
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다. 다시 입력하세요.");
            }
        }
    }
}