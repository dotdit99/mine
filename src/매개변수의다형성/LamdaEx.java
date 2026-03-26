package 매개변수의다형성;

// 람다(Lamda): 간단한 함수를 생성하기 위한 방법, 람다 표현식은 주로 함수형 프로그래밍 스타일로 지원함
// (매개변수목록) -> {실행문};
// 자바는 함수를 지원하지 않기 때문에 람다식을 사용하기 위해서는 함수형 인터페이스가 필요함

@FunctionalInterface
interface MyCalculator {
    int sum(int x, int y);
}

//class MyCalculatorImpl implements MyCalculator {
//    @Override
//    public int sum(int x, int y) {
//        return x + y;
//    }
//}


public class LamdaEx {
    public static void main(String[] args) {
        MyCalculator calc = (x, y) -> x + y;
        System.out.println(calc.sum(10, 20));

    }
}