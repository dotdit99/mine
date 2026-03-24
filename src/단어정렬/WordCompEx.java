package 단어정렬;

// 1. 길이가 짧은 것 부터
// 2. 길이가 같으면 사전 순으로
// 3. 중복 제거

import java.util.TreeSet;

public class WordCompEx {
    public static void main(String[] args) {
        TreeSet<String> words = new TreeSet<>(new WordComp());
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("grape");
        words.add("mango");
        words.add("orange");
        words.add("peach");
        words.add("lemon");
        words.add("melon");
        words.add("strawberry");

        for (String word : words) {
            System.out.println(word);
        }
    }
}

class WordComp implements java.util.Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
            return o1.length() - o2.length();
        }
        return o1.compareTo(o2);

    }
}
