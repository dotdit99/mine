package 사용자예외클래스;

// 자바에서 제공하는 예외 클래스가 사용목적에 맞지 않을 때 직접 예외 클래스를 만들어 사용할 수 있음


import java.util.Scanner;

public class CustomEx {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("정수값을 입력하세요 : ");
        int number = sc.nextInt();

        CheckEven checkEven = new CheckEven(); // 짝수를 체크하는 객체 생성
        checkEven.setNumber(number);
        try {
            System.out.println(checkEven.printEven());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class CustomException extends Exception {
    private Integer number = null;

    public CustomException(Integer number) {
        this.number = number;
    }

    @Override
    public String getMessage() {
        if (number == null) {
            return "number is null";
        } else {
            return number + " is not even";
        }
    }
}

class CheckEven {
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }


    public int printEven() throws CustomException {
        if (number % 2 == 0) {
            return number;
        } else {
            throw new CustomException(number);
        }
    }
}