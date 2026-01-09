package BOJ_1459_걷기;
import java.util.*;
public class Main {
    public static int solution(int n, int m, int ot, int ct) {
        int x = 0;
        int y = 0;
        int ans = 0;

        while (true) {
            int dx = n - x;
            int dy = m - y;

            if (dx == 0 && dy > 0) {
                y++;
                ans += ot;
            } else if (dy == 0 && dx > 0) {
                x++;
                ans += ot;
            } else if (dx > 0 && dy > 0) {
                if(ct >= 2 * ot) {
                    return (n + m) * ot;
                } else {
                    if((n - m) % 2 == 0) {
                        return Math.max(n, m) * ct;
                    } else {
                        return (Math.max(n, m) - 1) * ct + ot;
                    }
                }

            }

            if (x == n && y == m) break;
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int ot = sc.nextInt();
        int ct = sc.nextInt();

        System.out.println(solution(n,m,ot,ct));
    }
}
