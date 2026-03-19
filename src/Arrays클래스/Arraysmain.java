package Arrays클래스;

// Arrays 클래스: 배열을 다루기 위한 다양한 메서드가 포함되어 있음. (그렇게 많이 쓸 이유는 없음)


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Arraysmain {
    public static void main(String[] args) {
        Integer arr[] = {5, 3, 4, 7, 8, 9, 2, 99, 300, 450, 999, 1};
        Arrays.sort(arr); // sort: 오름차순 정렬
        System.out.println(Arrays.toString(arr));

        // 내림 차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.binarySearch(arr, 999));

        // 정렬 조건 오버라이딩
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) { // 오름 차순
                    return 1;
                } else if (o1 < o2) {// 그냥 현 상태 유지
                    return -1;
                } else
                    return 0; // 두개의 값이 같나는 의미
            }

        });
        System.out.println(Arrays.toString(arr));
    }
}
