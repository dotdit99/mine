package 문자열다루기;

// StringBuffer, StringBuilder: 문자열을 추가하거나 변경할 때 사용
// String: 문자열을 추가하거나 변경할 때 사용, 멀티스레드를 고려 하지 않음

public class StringMain {
    public static void main(String[] args) {
        String rst = "Hello";
        rst += " ";
        rst += "java";
        rst += " ";
        rst += "Programming";

        System.out.println(rst);

        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        sb.append(" ");
        sb.append("Java");
        sb.append(" ");
        sb.append("Programming");
        System.out.println(sb);

    }
}
