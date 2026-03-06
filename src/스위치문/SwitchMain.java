package 스위치문;

import java.util.Scanner;

// Switch 문: 조건값으로 분기
// 분기된 조건을 실행한 후 break문을 통해서 switch문을 벗어 나야 함
public class SwitchMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("좋아하는 계절을 입력하세요 : ");
        String season = sc.next().toUpperCase(); // 문자열을 대문자로 변경해서 대입 받음
        switch (season){
            case "SPRING": //세미콜론이 아니고 콜론이 와야 함
                System.out.println("꽃이 피는 봄이 좋아요.");
                break;
            case "SUMMER":
                System.out.println("여름 휴가가 있는 여름이 좋아요.");
                break;
            case "FALL":
            case "AUTUMN": // OR 조건과 동일한 역할을 함
                System.out.println("화창한 가을이 좋아요");
                break;
            case "WINTER":
                System.out.println("눈 내리는 겨울이 좋아요.");
                break;
            default:
                System.out.println("계절 입력이 잘못되었습니다.");
                break;
        }

    }
}
