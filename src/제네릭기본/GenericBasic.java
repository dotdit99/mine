package 제네릭기본;

// 제네릭: 데이터의 타입을 일반화하여 다양한 타입의 데이터를 하나의 코드로 처리할 수 있도록 해주는 자바의 기능
// - 컴파일 시 타입을 지정하여 타입 안정성 확보
// - 불필요한 형변환 제거
// - 코드 재사용성 증가

import java.util.ArrayList;
import java.util.List;

public class GenericBasic {
    public static void main(String[] args) {
        List list= new ArrayList<>();
        list.add("정경수");
        list.add("안유진");
        list.add("장원영");

        for (Object name : list){
            String str = (String) name;
            System.out.println(str);

        }

        Person<String> p1 = new Person<>("곰돌이");
        System.out.println(p1.getInfo());
        Person<Integer> p2 = new Person<>(1004);
        System.out.println(p2.getInfo());
    }
}

// T는 예약어는 아니고 관례상 대문자 T로 많이 사용
class Person<T>{
    private T info;
    public Person(T info){
        this.info = info;
    }
    public T getInfo(){
        return info;
    }
}
