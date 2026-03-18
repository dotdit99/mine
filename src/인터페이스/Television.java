package 인터페이스;


public class Television implements RemoCon{
    private int volume;
    private int channel;

    @Override
    public void turnON(){
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOFF(){
        System.out.println("TV를 끕니다.");

    }

    @Override
    public void setMute(boolean mute){
        if (mute) System.out.println("TV를 무음 처리 합니다.");
        else System.out.println("TV 무음 해제 합니다.");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > RemoCon.MAX_VOLUME){
            this.volume = RemoCon.MAX_VOLUME;
        }else if (volume < RemoCon.MIN_VOLUME){
            this.volume = RemoCon.MIN_VOLUME;
        }else {
            this.volume = volume;
        }
        System.out.println("현재 TV 볼륨은 " + this.volume);

    }
    public void setChannel(int channel) {
        if (channel >= 1 && channel <= 999){
            this.channel = channel;
        }else {
            System.out.println("채널 설정 범위가 아닙니다.");
        }
    }
}
