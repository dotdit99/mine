package 명령어이력조회;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HistoryEx {
    final static Queue<String> queue = new LinkedList<>();
    final static int MAX_SIZE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            // ✅ 수정 1: 루프 안에서 입력 받기
            String cmd = sc.nextLine().trim();

            if (cmd.equalsIgnoreCase("q")) {
                System.exit(0);
            } else if (cmd.equalsIgnoreCase("help")) {
                System.out.println("help - 도움말을 보여 줍니다.");
                System.out.println("q/Q - 프로그램 종료");
                System.out.println("history - 최근 입력한 명령어를 " + MAX_SIZE + "개 출력");
            } else if (cmd.equalsIgnoreCase("history")) {
                save(cmd);
                int cnt = 0;
                for (String s : queue) {
                    cnt++;
                    System.out.println(cnt + " : " + s);
                }
            } else {
                save(cmd);
                System.out.println(cmd);
            }
        }
    }

    static void save(String cmd) {
        queue.offer(cmd);
        if (queue.size() > MAX_SIZE) {
            queue.remove();
        }
    }
}