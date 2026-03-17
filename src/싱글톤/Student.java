package 싱글톤;

public class Student {
    // 이미 생성되어 있는 싱글톤 객체의 주소를 대입 받음
    SingleTon singleTon = SingleTon.getInstance();

    // 만들어져 있는 싱글톤 객체의 내용을 변경ㄴ
    void setInfo(String name, int id){
        singleTon.name = name;
        singleTon.id = id;
    }

    void printInfo(){
        System.out.println("이름: " + singleTon.name);
        System.out.println("아이디: " + singleTon.id);
    }
}
