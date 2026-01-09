package BOJ_1106_호텔;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int need = sc.nextInt();
        int m = sc.nextInt();

        int[][] cities = new int[m][2];
        for (int i = 0; i < m; i++) {
            cities[i][0] = sc.nextInt();  // cost
            cities[i][1] = sc.nextInt();  // brings this many customers
        }

        final int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[need + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // 언바운디드 냅색
        for (int[] city : cities) {
            int cost = city[0];
            int people = city[1];
            for (int i = 1; i <= need; i++) {
                int prev = Math.max(0, i - people);
                dp[i] = Math.min(dp[i], dp[prev] + cost);
            }
        }
        System.out.println(dp[need]);
    }
}
