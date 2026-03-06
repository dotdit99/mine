package 주사위게임;

// int rand = (int) (Math.random() * 6) + 1; // 1 ~ 6 사이의 임의의 정수를 생성함

public class RandomEx {
    public static void main(String[] args) {
        // 2개의 주사위를 굴려서 2개의 같은 수가 나오면 무인도 탈출
        // 탈출 시 2개의 주사위 값을 표시하고, 몇번만에 탈출했는지 횟수 표시

        int count = 0; // 시도 횟수

        while (true) { // 같은 수가 나올 때까지 반복
            // 1 ~ 6 사이의 임의의 정수 생성
            count++; // 시도 횟수 증가
            int rand1 = (int) (Math.random() * 6) + 1;
            int rand2 = (int) (Math.random() * 6) + 1;


            // 두 주사위 값이 같으면 탈출
            if (rand1 == rand2) {
                System.out.println("주사위1 값: " + rand1 + " | 주사위2 값: " + rand2);
                System.out.println(count + "번 만에 탈출했습니다.");
                break; // while문 탈출
            }
        }
    }
}