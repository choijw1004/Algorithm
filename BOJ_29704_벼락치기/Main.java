package BOJ_29704_벼락치기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int total = 0;

        int[][] tasks = new int[n][2];
        int[] dp = new int[T+1];

        for(int i = 0 ; i <n; i++){
            tasks[i][0] = sc.nextInt();
            int b = sc.nextInt();
            total += b;
            tasks[i][1] = b;
        }

        for(int[] task : tasks){
            int cost = task[0];
            int val = task[1];

            for(int i = T; i - cost >=0; i--){
                dp[i] = Math.max(dp[i], dp[i-cost] + val);
            }
        }


        System.out.println(total - dp[T]);



    }
}
