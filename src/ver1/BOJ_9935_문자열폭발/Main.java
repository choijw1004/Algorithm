package BOJ_9935_문자열폭발;
import java.util.*;

public class Main {
    public static String solution(String s, String t) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() >= t.length()) {
                boolean ex = true;
                for (int j = 0; j < t.length(); j++) {
                    if (sb.charAt(sb.length() - t.length() + j) != t.charAt(j)) {
                        ex = false;
                        break;
                    }
                }
                if (ex) {
                    sb.delete(sb.length() - t.length(), sb.length());
                }
            }
        }

        return sb.length() == 0 ? "FRULA" : sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(solution(s,t));
    }
}
