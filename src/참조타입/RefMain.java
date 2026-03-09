package 참조타입;

// 기본 타입: 할당 받은 메모리 공간에 값이 대입되는 방식 (boolean, int, char, long 등등)
// 참조 타입: 할당 받은 메모리 공간에 객체의 주소가 대입되는 방식 (배열, 열거 타입, 클래스, 인터페이스)

public class RefMain {
    public static void main(String[] args) {
        String name1 = "안유진";
        String name2 = "안유진";
        String name3 = new String("안유진");
        
        // 주소를 비교
        if (name1 == name3){ // 주소를 비교하게 됨, 즉 참조하는 문자열의 주소가 같은지 확인
            System.out.println("name1과 name2가 참조하는 문자열의 주소가 같음");
        }else {
            System.out.println("name1과 name2가 참조하는 문자열의 주소가 다름");
        }
        // 값을 비교
        if (name1.equals(name3)){ //문자열의 내용이 같은지 비교
            System.out.println("name1과 name2의 내용이 같음");
        }else {
            System.out.println("name1과 name2의 내용이 다름");
        }
    }
}
