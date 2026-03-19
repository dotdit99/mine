package 어레이리스트;

// List 인터페이스:


import java.util.List;
import java.util.ArrayList;

public class ListMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("JAVA");
        list.add("PYTHON");
        list.add("C++");
        list.add("C#");
        list.add("JavaScript");

        // 특정 인덱스에 요소 추가
        list.add( 2, "PHP");

        // 특정 인덱스의 요소 가져오기
        System.out.println(list.get(5));

        // 인덱스로 요소 제거]
        list.remove(2);

        // 크기 가져 오기
        System.out.println(list.size());

        // 값의 포함 여부 확인
        System.out.println(list.contains("JAVA"));

        for (String lang : list)
            System.out.println(lang);
    }
}
