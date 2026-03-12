package 상속TV;

// 상속을 주기 위한 TV 만들기

public class ProtoTypeTV {
    // 전원
    protected boolean power;
    // 채널
    protected int channel;
    // 볼륨
    protected int volume;
    
    // 매개변수가 없는 생성자=기본 생성자
    public ProtoTypeTV(){
        power = false;
        channel = 1;
        volume = 10;
    }
    // 매개변수가 전부 있는 생성자: ProtoTypeTV(boolean power, int chn, int vol)
    public ProtoTypeTV(boolean power, int cnl, int vol){
        this.power = power;
        setChannel(cnl);
        this.volume = vol;
    }
    // 채널 설정은 1 ~ 999까지 설정 가능하도록 만들기
    public void setChannel(int cnl) {
        // 1. 먼저 값이 유효한지 확인합니다.
        if (cnl > 0 && cnl < 1000) {
            this.channel = cnl; // 유효할 때만 저장
        } else {
            // 2. 유효하지 않으면 저장하지 않고 경고만 출력합니다.
            System.out.println("채널 입력이 잘못되었습니다. (1~999 사이만 가능)");
        }
    }

    void setVolume(int vol){
        this.volume = vol;
    }

    // 전원을 켜고 끄는 기능 만들기
    void setPower(boolean on){
        this.power = on;
        System.out.println("전원을 " + (on ? "ON" : "OFF") + "했습니다.");
    }
}
