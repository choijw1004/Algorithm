package BOJ_2073_수도배관공사;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] pipes = new int[m][2];

        for(int i = 0 ; i < m; i++){
            pipes[i][0] = sc.nextInt();
            pipes[i][1] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = Integer.MAX_VALUE;

        for(int[] pipe : pipes){
            int cost = pipe[0];
            int val = pipe[1];

            for(int i = n; i >= cost; i--){
                dp[i] = Math.min(dp[i], dp[i-cost] + val);
            }
        }

        System.out.println(dp[n]);

    }
}
