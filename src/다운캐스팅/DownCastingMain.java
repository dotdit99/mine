package 다운캐스팅;

// 다운캐스팅: 상위 클래스 타입으로 선언된 객체를 다시 하위 클래스 타입으로 형변환하는 것

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DownCastingMain {
    ArrayList<Animal> animals = new ArrayList<>();
    public static void main(String[] args) {
       DownCastingMain downCasting = new DownCastingMain();
       downCasting.addAnimal();
       downCasting.downCast();
    }

    
    public void addAnimal(){
        animals.add(new Animal());
        animals.add(new Human());
        animals.add(new Tiger());
        animals.add(new Eagle());

        for (Animal animal : animals){
            animal.move();
        }
    }

    public void downCast(){
        for (Animal animal : animals){
            if (animal instanceof Human human){
                human.readBook();
            } else if (animal instanceof Tiger tiger){
                tiger.hunting();
            } else if (animal instanceof Eagle eagle) {
                eagle.flying();
            } else{
                System.out.println("지원되지 않는 형 입니다.");
            }
        }
    }
}

class  Animal{
    public void move(){
        System.out.println("동물이 움직입니다.");
    }
}

class  Human extends  Animal {
    @Override
    public void move(){
        System.out.println("사람이 두 발로 걷습니다.");
    }
    public void  readBook(){
        System.out.println("사람이 책을 읽습니다.");
    }
}

class Tiger extends Animal{
    @Override
    public void move() {
        System.out.println("호랑이가 네 발로 뜁니다.");
    }
    public void hunting(){
        System.out.println("호랑이가 사냥을 합니다.");
    }
}

class Eagle extends Animal{
    @Override
    public void move() {
        System.out.println("독수리가 하늘을 납니다.");
    }
    public  void flying(){
        System.out.println("독수리가 날개를 쭉 펴고 멀리 날아갑니다.");
    }
}

