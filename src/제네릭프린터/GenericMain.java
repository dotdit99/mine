package 제네릭프린터;

public class GenericMain {
    public static void main(String[] args) {
        // 1. Powder 전용 프린터
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
        powderPrinter.setMaterial(new Powder());
        System.out.println(powderPrinter);

        // 2. Plastic 전용 프린터 (타입을 Plastic으로 변경)
        GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
        plasticPrinter.setMaterial(new Plastic());
        System.out.println(plasticPrinter);

        // 3. Ink 전용 프린터 (타입을 Ink로 변경)
        GenericPrinter<Ink> inkPrinter = new GenericPrinter<>();
        inkPrinter.setMaterial(new Ink());
        System.out.println(inkPrinter);
    }
}