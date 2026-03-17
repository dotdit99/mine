package 자동차;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SportsCar sportsCar = new SportsCar(sc.nextLine());
        Sedan sedan = new Sedan(sc.nextLine());
        Bus bus = new Bus(sc.nextLine());

    }
}
