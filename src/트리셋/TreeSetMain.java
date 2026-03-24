package 트리셋;

// 트리셋(TreeSet): 이진 검색 트리 기반의 Set 컬렉션
// ┗ 요소가 자동으로 정렬됨
// ┗ 중복 허용하지 않음
// ┗ 삽입, 삭제, 검색: O(log n)
// ┗ 중위 순회시 오름차순 출력 가능


import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(23);
        treeSet.add(10);
        treeSet.add(48);
        treeSet.add(15);
        treeSet.add(7);
        treeSet.add(22);
        treeSet.add(56);

        for (int e : treeSet) {
            System.out.println(e + " ");
        }
        System.out.println();

    }
}
