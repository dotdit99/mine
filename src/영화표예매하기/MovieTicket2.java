package 영화표예매하기;

import java.util.Scanner;

public class MovieTicket2 {
    //인스턴스 필드로 좌석 10개를 저장하는 배열 생성
    private final int seat[];
    int price;
    private Scanner sc;

    // 생성자를 통해서 가격을 전달 받음
    MovieTicket2(int price) {
        seat = new int[10];
        this.price = price;
        sc = new Scanner(System.in);
    }

    // 좌석 상태 출력
    public void printSeat() {
        for (int e : seat) {
            System.out.print(e == 0 ? "[ ]" : "[V]");
        }
        System.out.println();
    }

    // 입력 받은 좌석 번호 유효성 체크: 1 ~ 10 사이
    private boolean isValidSeatNumber(int seatPosition){
        return seatPosition >= 1 && seatPosition <= 10; // true
    }

    // 좌석 예매 기능
    public void selectSeat(){
        printSeat(); // 현재 좌석 상태를 확인하는 메서드
        System.out.print("예매할 좌석 번호(1 ~ 10): ");
        int num = sc.nextInt();
        if (!isValidSeatNumber(num)){
            System.out.println("좌석 번호가 잘못 입력 되었습니다.");
            return;
        }
        if (seat[num -1] == 0){
            seat[num - 1 ] =1; // 예매하기
            System.out.println(num + "번 좌석 예매 완료");
            printSeat(); // 예매 완료 후 좌석 변경 상태를 보여주기
        } else{
            System.out.println("이미 예약된 좌석입니다. 다른 좌석을 예매 하세요.");
        }
    }

    // 좌석 취소하기
    public void cancelSeat(){
        printSeat(); // 현재 좌석 상태를 확인하는 메서드
        System.out.print("취소할 좌석 번호(1 ~ 10): ");
        int num = sc.nextInt();
        if (!isValidSeatNumber(num)){
            System.out.println("좌석 번호가 잘못 입력 되었습니다.");
            return;
        }
        if (seat[num -1] == 1){
            seat[num - 1 ] = 0; // 취소하기
            System.out.println(num + "번 좌석 취소 완료");
            printSeat(); // 취소 완료 후 좌석 변경 상태를 보여주기
        } else{
            System.out.println("해당 좌석은 예매되어 있지 않습니다.");
        }
    }

    // 총 판매 구입 금액 반환
    public int getTotalPrice(){
        int cnt = 0;
        for (int e: seat){
            if (e == 1){
                cnt++; // 판매된 좌석 개수를 누적
            }
        }
        return cnt * price;
    }
}