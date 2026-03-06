package 스위치실습;

// BMI 계산하기

import java.util.Scanner;

public class SwitchEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float h = scanner.nextFloat();
        h /= 100;
        float kg = scanner.nextFloat();
        float bmi = kg / (h * h) ;
        String result;
        if (bmi < 18.5){
            result = "저체중";
        } else if (bmi < 23) {
            result = "정상";
        }else if (bmi < 25) {
            result = "과체중";
        }else{
            result = "비만";
        }
        scanner.close();
        System.out.printf("BMI는 %.2f 입니다.\n%s 입니다.",bmi, result);
    }
}
