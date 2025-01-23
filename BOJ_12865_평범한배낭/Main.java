package BOJ_12865_평범한배낭;
import java.util.*;

public class Main {

    //N 물품의 수, K 무게.
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        int[][] items = new int[N][2];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                items[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1 ; i <= N; i++){
            int currWeight = items[i - 1][0];
            int currVal = items[i - 1][1];
            for(int j = 0; j <= K; j++){
                if(j < currWeight){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j - currWeight] + currVal, dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
