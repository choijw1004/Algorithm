package BOJ_14728_벼락치기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int maxTime = sc.nextInt();

        int[][] pb = new int[N][2];
        int[][] dp = new int[N+1][maxTime+1];

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < 2; j++) {
                pb[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= N; i++){
            int currTime = pb[i-1][0];
            int currVal = pb[i-1][1];

            for(int j = 0 ; j <= maxTime; j++){
                if(j < currTime){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-currTime] + currVal, dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][maxTime]);
    }
}
