package 집합기본;

import java.util.HashSet;
import java.util.Set;

// Set (집합): 중복을 허용하지 않음 (hashCode()와 equals() 의 반환값으로 중복 여부를 확인)
// HashSet(): 순서를 유지하지 않음

public class SetMain {
    public static void main(String[] args) {
        //Set<String> set = new HashSet<String>();
        //set.add("Java");
        //set.add("Python");
        //set.add("C#");
        //set.add("C++");
        //set.add("JavaScript");
        //set.add("Java"); // 중복된 값은 허용하지 않음
        //System.out.println(set);

        Set<MemberSet> set = new HashSet<>();

        set.add(new MemberSet(1001, "유나"));
        set.add(new MemberSet(1002, "예나"));
        set.add(new MemberSet(1003, "아현"));
        set.add(new MemberSet(1001, "카리나"));

        System.out.println(set);
    }
}
