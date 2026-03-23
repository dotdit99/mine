package 집합로또번호생성기;

// 1 ~ 45 사이의 임의의 수 6개 생성, 중복되면 안됨
// 1. ArrayList 사용
// 2. 집합 사용

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        int a;
        for (int i = 0; i < 6; i++) {
            a = (int) (Math.random() * 45) + 1; // 1 ~ 45 사이의 임의의 정수 생성
            if (!list.contains(a)) {           // list에 a가 없을 때만
                list.add(a);                   // 추가
            }
        }
        System.out.println(list);

        Set<Integer> lottoSet = new HashSet<>();
        while (lottoSet.size() < 6) {              // Set<>은 중복 자동 처리
            lottoSet.add((int) (Math.random() * 45) + 1);
        }
        System.out.println(lottoSet);


    }
}
