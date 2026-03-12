package 접근제한자;

public class Parent {
    protected String  name; // 부모님 이름
    protected String address; // 부모님 주소
    protected int money; // 부모님 재산
    public Parent(){
        name = "부자 아빠";
        address = "서울시 강남구 청담동";
        money = 1000000000;
    }
}
//public String getName(){
//    return name;
//}
//public String getAddress(){
//    return address;
//}
//public int getMoney(){
//    return money;
//}