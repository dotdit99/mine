package 도서관리시스템;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BookMain {
    public static void main(String[] args) {
        Set<Book> set = new HashSet<Book>();

        set.add(new Book(1001, "눈물을 마시는 새", "이영도"));
        set.add(new Book(1002, "피를 마시는 새", "이영도"));
        set.add(new Book(1003, "드래곤 라자", "이영도"));
        set.add(new Book(1003, "오버 더 호라이즌", "이영도"));

        for (Book book : set) {
            book.showBook();
        }

        // 합집합: 모든 요소가 포함된, 단 중복은 제거 됨
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
        // 합집합
        //set1.addAll(set2);
        //System.out.println(set1);

        // 교집합
        set1.removeAll(set2);
        System.out.println(set1);
    }

}