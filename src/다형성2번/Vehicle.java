package 다형성2번;

public class Vehicle {
    public void move(){
         System.out.println("차량이 달립니다.");

    }
}

class Bus extends Vehicle{
    @Override
    public void move(){
        System.out.println("버스가 다닙니다.");
    }
}

class Taxi extends Vehicle{
    @Override
    public void move(){
        System.out.println("택시가 다닙니다.");
    }
}

class SportCar extends Vehicle{
    @Override
    public void move(){
        System.out.println("스포츠카가 달립니다.");
    }
}

class SUV extends Vehicle{
    @Override
    public void move(){
        System.out.println("SUV가 달립니다.");
    }
}

class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }
        void drive (Vehicle vehicle){
            System.out.print(name + "의 ");
            vehicle.move();

        }
    }
