package BOJ_18332_ValidEmail;
import java.util.*;

public class Main {
    private static int solution(List<String> emails){
        HashSet<String> set = new HashSet<>();

        for(String email : emails){
            String[] split = email.split("@");

            String name = split[0];
            String domain = split[1];

            name = name.toLowerCase();
            if(name.charAt(0) == '.' || name.charAt(name.length() -1) == '.') continue;
            if(name.contains("..")) continue;

            name.replace('.', ' ');
            name.trim();
            if(name.length() < 6 || name.length() > 30) continue;

            if(domain.length() < 3 || domain.length() > 31) continue;
            if(domain.charAt(0) == '.' || domain.charAt(domain.length() -1) == '.') continue;

            name.concat(domain);

            set.add(name);
        }

        return set.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> emails = new ArrayList<>();

        for(int i = 0 ; i < n; i++) emails.add(sc.next());

        System.out.println(solution(emails));

    }
}
