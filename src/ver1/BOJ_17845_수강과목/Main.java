package BOJ_17845_수강과목;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();

        int[][] subjects = new int[n][2];
        for(int i = 0; i < n; i++){
            subjects[i][0] = sc.nextInt();
            subjects[i][1] = sc.nextInt();
        }

        System.out.println(solution(capacity, subjects));
    }

    public static int solution(int capacity, int[][] subjects) {
        int n = subjects.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int currValue = subjects[i - 1][0];
            int currWeight = subjects[i - 1][1];
            for (int w = 0; w <= capacity; w++) {
                if (w < currWeight) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - currWeight] + currValue);
                }
            }
        }

        return dp[n][capacity];
    }
}
