package 영화표예매하기;

import java.util.Scanner;

public class MovieTicket {

    // 좌석 이름 배열
    String chairs[] = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10"};

    // 예매 여부 배열 (false = 빈 좌석, true = 예매됨)
    boolean[] isBooked = new boolean[10];

    // 좌석 가격 필드
    private int price;

    // 입력을 받기 위한 스캐너
    Scanner scanner = new Scanner(System.in);

    // 생성자: 가격을 매개변수로 전달받음
    public MovieTicket(int price) {
        this.price = price;
    }

    // 좌석 상태 출력 메서드
    public void printSeats() {
        System.out.println("===== 좌석 현황 =====");
        for (int i = 0; i < chairs.length; i++) {
            if (isBooked[i]) {
                System.out.print("[V] " + chairs[i] + "  ");
            } else {
                System.out.print("[ ] " + chairs[i] + "  ");
            }
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("====================");
    }

    // 예매 기능 수행하는 메서드
    public void book() {
        System.out.print("예매할 좌석을 입력하세요 (예: A1 A2 A3): ");

        String line = scanner.nextLine();
        String[] inputs = line.split(" ");

        for (int j = 0; j < inputs.length; j++) {
            String seat = inputs[j];

            boolean found = false;
            for (int i = 0; i < chairs.length; i++) {
                if (chairs[i].equals(seat)) {
                    found = true;
                    if (isBooked[i]) {
                        System.out.println(seat + "는 이미 예매된 좌석입니다.");
                    } else {
                        isBooked[i] = true;
                        System.out.println(seat + " 예매 완료!");
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println(seat + "는 존재하지 않는 좌석입니다.");
            }
        }
    }

    // 취소 기능 수행하는 메서드
    public void cancel() {
        System.out.print("취소할 좌석을 입력하세요 (예: A1 ~ A10): ");

        String line = scanner.nextLine();
        String[] inputs = line.split(" ");

        for (int j = 0; j < inputs.length; j++) {
            String seat = inputs[j];

            boolean found = false;
            for (int i = 0; i < chairs.length; i++) {
                if (chairs[i].equals(seat)) {
                    found = true;
                    if (!isBooked[i]) {
                        System.out.println(seat + "는 예매되지 않은 좌석입니다.");
                    } else {
                        isBooked[i] = false;
                        System.out.println(seat + " 취소 완료!");
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println(seat + "는 존재하지 않는 좌석입니다.");
            }
        }
    }

    // 총 판매 금액 반환하는 메서드
    public int getTotalSales() {
        int count = 0;
        for (int i = 0; i < isBooked.length; i++) {
            if (isBooked[i]) {
                count++;
            }
        }
        return count * price;
    }
}