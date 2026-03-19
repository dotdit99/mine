package 정렬실습;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("과일 이름 10개 입력: ");
        String[] fruits = sc.nextLine().split(" ");

        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1; // 길이가 길면 뒤로 보냄 (오름차순)
                } else if (o1.length() < o2.length()) {
                    return -1; // 길이가 짧으면 현 상태 유지
                } else {
                    // 길이가 같으면 사전순 정렬
                    return o1.compareTo(o2);
                }
            }
        }); // 중괄호와 소괄호 짝을 확인하세요: }) + );

        System.out.println(Arrays.toString(fruits));
    }
}