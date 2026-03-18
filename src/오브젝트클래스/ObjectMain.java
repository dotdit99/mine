package 오브젝트클래스;

//Object 클래스: 모든 클래스의 최상위 부모 클래스
// toString(): 객체의 정보를 문자열로 반환 (클래스명@16진수_해시코드)
// equals(Object obj): 두 객체가 같은지 비교, String 클래스에서는 문자열 내용을 비교하도록 오버라이딩이 되어 있음


public class ObjectMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        if (student1 == student2 ){
            System.out.println("참조기호 있는 객체의 주소가 같음");
        }

        if (student1.equals(student2)){
            System.out.println("참조하고 있는 객체가 같은지 비교");
        }

        System.out.println(student1);
        System.out.println(student1.hashCode());
    }
}

class Student extends Object{
    String name;
    int age;

    Student (){
        name = "곰돌이";
        age = 20;
    }

    //@Override
    //public String toString() {
    //    return "Student [name=" + name + ", age=" + age + "]";
    //}
}
