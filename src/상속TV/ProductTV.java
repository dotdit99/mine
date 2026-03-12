package 상속TV;

// ProtoTypeTV를 상속받아서 ProductTV 클래스 생성 | 부모클래스가 자식클래스에게 상속을 줄 때 기본생성자를 자동으로 물려줌
public class ProductTV extends ProtoTypeTV{
    String name;
    boolean isSmart;

    ProductTV(){
        super();
        this.name = "TV";
        isSmart = false;
    }

    //생성자 오버로딩
    ProductTV(boolean power, int cnl, int vol, String name){
        // 부모의 생성자를 불러 줌, 자식 객체가 만들어 질려면 생성자에서 부모의 생성자를 먼저 불러 줘야 함
        super(power, cnl, vol);
        // this 생략이 불가능한 경우 (필수)
        // 매개변수(Parameter)의 이름과 클래스의 필드(Field) 이름이 같을 때
        this.name = name;
        // this는 생략 가능
        isSmart = false;
    }

    // 볼륨 설정 기능 추가 0 ~ 100까지만 유효값으로 입력 받게 하고 나머지 오류 처리
    @Override
    public void setVolume(int vol) {
    if (vol >= 0 && vol <= 100) {
        volume = vol; // 유효할 때만 저장
        System.out.println("볼륨을 " + vol + "로 변경 했습니다.");
    }else {
        // 2. 유효하지 않으면 저장하지 않고 경고만 출력합니다.
        System.out.println("볼륨 입력이 잘못되었습니다. (1~100 사이만 가능)");
    }
}
    // 채널 설정 기능을 오버라이딩 해서 1 ~ 1999까지 설정되도록 변경
    @Override
    public void setChannel(int cnl) {
        if (cnl >= 1 && cnl < 2000) {
            channel = cnl;
            System.out.println("채널을 " + cnl + "로 변경 했습니다.");
        }else {
            System.out.println("채널 설정이 잘못되었습니다.");
        }
    }

    // 오버라이딩된 설정 기능을 오버로딩해서 스마트 모드 추가
    // 스마트 기능을 켜면 인터넷 기능이 켜지고 채널 설정은 무시됨
    void setChannel(int cnl, boolean smart){
        if(smart){
            isSmart = true;
        }else {
            setChannel(cnl);
        }
    }

    // 티비 정보 출력 기능
    void printTV(){
        System.out.println("===== TV 정보 출력 =====");
        System.out.println("이름: " + name);
        System.out.println("전원: " + (power ? "ON" : "OFF"));
        System.out.println("채널: " + channel);
        System.out.println("볼륨: " + volume);
        System.out.println("스마트 모드: " + (isSmart ? "ON" : "OFF"));
    }
}
