package 제네릭실습;

public abstract class Device {
    public abstract void turnOn();
    public abstract void turnOff();
}

class Printer extends Device {
    @Override
    public void turnOn() {
        System.out.println("프린터 전원을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("프린터 전원을 끕니다.");
    }
}

class KeyBoard extends Device {
    @Override
    public void turnOn() {
        System.out.println("키보드 전원을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("키보드 전원을 끕니다.");
    }
}

class Monitor extends Device {
    @Override
    public void turnOn() {
        System.out.println("모니터 전원을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("모니터 전원을 끕니다.");
    }
}



