package BMI계산기;

//BMI(체질량 지수): BMI = 몸무게(kg) / 키(m) * 키(m)
// 18.5 미만: 저체중
// 23.5 미만 : 정상
// 25 미만: 과체중
// 25 이상: 비만

import java.util.Scanner;

public class BMIMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 키(cm), 몸무게 입력
        System.out.print("키(cm)를 입력하세요: ");
        double height = sc.nextDouble(); // 실수 타입으로 키를 입력받음
        System.out.print("몸무게(kg)를 입력하세요: ");
        double  weight = sc.nextDouble();
        // 키를 미터 단위로 환산 후  BMI 계산
        double mHeight = height / 100;
        double bmi = weight / (mHeight * mHeight);
        // BMI 값 출력
        System.out.printf("당신의 BMI는 %.2f 입니다.\n",bmi);
        // 조건문으로 체형 분류 후 결과 출력
        if (bmi < 18.5)
            System.out.println("저체중입니다.");
        else if (bmi < 23 )
            System.out.println("정상 체중입니다.");
        else if (bmi < 25)
            System.out.println("과체중 입니다.");
        else
            System.out.println("비만 입니다.");

    }
}
