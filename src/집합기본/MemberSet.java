package 집합기본;

public class MemberSet {
    int id;
    String name;

    public MemberSet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MemberSet) {
            MemberSet member = (MemberSet) obj;
            if (this.id == member.id) {
                return true;  // ✅ id가 같으면 true 반환
            } else {
                return false;
            }
        }
        return false; // ✅ MemberSet 타입이 아니면 false 반환
    } // ✅ equals() 닫는 중괄호 추가

    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + "]";
    }
}