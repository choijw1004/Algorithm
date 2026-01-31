package ver2.BOJ_퇴사;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] dp = new int[n+2];

        for(int i = 1 ; i <= n; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for(int i = n; i >= 1; i--){
            if(i + T[i] > n+1){
                dp[i] = dp[i+1];
            }

            else{
                dp[i] = Math.max(dp[i+1], P[i] + dp[i + T[i]]);
            }
        }

        System.out.println(dp[1]);

    }
}
