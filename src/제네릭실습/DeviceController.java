package 제네릭실습;

public class DeviceController<T extends Device> {
    private T device;

    public void setDevice(T device) {
        this.device = device;
    }

    public void powerOn() {
        if (device != null) {
            device.turnOn();
        }else {
            System.out.println("장치가 연결되지 않았습니다.");
        }
    }
    public void powerOff() {
        if (device != null) {
            device.turnOff();
        }else {
            System.out.println("장치가 연결되지 않았습니다.");
        }
    }
}
