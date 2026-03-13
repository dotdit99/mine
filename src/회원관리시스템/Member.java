package 회원관리시스템;

public class Member {
    static int totalCount; //(전체 가입 회원 수: 모든 객체가 공유하는 변수)
    int id; //(회원번호: 각 회원 객체마다 고유하게 가지는 변수)
    String name; //(이름: 각 회원의 이름을 저장하는 변수)
    String userId;// (아이디: 각 회원의 접속 아이디를 저장하는 변수)
    String password; //(비밀번호: 각 회원의 비밀번호를 저장하는 변수)
    int age; //(나이: 각 회원의 나이를 저장하는 변수)

    public Member(String name, String userId, String password, int age) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.age = age;

        totalCount++;       // 전체 회원 수 증가
        this.id = totalCount; // 증가된 숫자를 본인의 ID로 저장
    }

    static int getTotalCount() {
        return totalCount;
    }

    static void decreaseTotalCount() {  // ← 추가된 메서드
        totalCount--;
    }

    public String getUserId() {
        return userId;
    }

    boolean login(String userId, String password) {
        if (this.userId.equals(userId) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    void changePassword(String oldPw, String newPw) {
        if (this.password.equals(oldPw)) {
            password = newPw;
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }

    void updateInfo(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("회원 정보가 수정되었습니다.");
    }

    void printInfo() {
        System.out.println("회원번호: " + id + " 이름: " + name + " 아이디: " + userId + " 나이: " + age + "세");
    }
}