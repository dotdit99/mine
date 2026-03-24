package 스택;

// Stack: LIFO(라스트 인 퍼스트 아웃) 나중에 저장된 자료가 먼저 제거되는 자료 구조
// ┗ 내부적으로 Vector 클래스를 상속 받아 만들어짐(문제점은 메서드가 너무 많음) - 원래는 제한이 있어야 함

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek()); // 맨 위의 값을 확인
        System.out.println(stack.pop()); // 맨 위의 값을 끄집어 내면서 보여줌
        System.out.println(stack.empty()); // 스택이 비어있는지 확인
        System.out.println(stack.size()); // 스택의 크기 확인
        System.out.println(stack.contains(2)); // 2가 포함되어 있는지 확인

        for (Integer e : stack) {
            System.out.println(e + " ");
        }

    }
}
