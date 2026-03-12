package 다형성2번;

import java.util.Scanner;

public class PolyMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        // 운전자 생성
        Driver driver = new Driver(name);
        while (true){
            int num = sc.nextInt();
            switch (num){
                // 1. 버스
                case 1:
                    driver.drive(new Bus());
                    return;
                // 2. 택시
                case 2:
                    driver.drive(new Taxi());
                    return;
                // 3. 스포츠카
                case 3: {
                    driver.drive(new SportCar());
                    return;
                }
                case 4: {
                    driver.drive(new SUV());
                    return;
                }
                default: {
                    System.out.println("메뉴 선택이 잘못 되었습니다.");
                    break;
                }
            }

        }

        // 실습 예제: 차량을 추가해 보기

        // 오버라이딩 -> 오버로딩으로 변경 가능한지 검토 (Driver 클래스의 drive 메서드)

    }
}

