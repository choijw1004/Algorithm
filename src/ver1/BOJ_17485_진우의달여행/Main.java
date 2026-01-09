package BOJ_17485_진우의달여행;
import java.util.*;

public class Main {
    public static int solution(int N, int M, int[][]map ){
        int ans = 0;
        int[][][] dp = new int[N][M][3];
        for(int i = 0 ; i < M; i++){
            for(int j = 0 ; j < 3; j++){
                dp[0][i][j] = map[0][i];
            }
        }



        for(int i = 1 ; i < N; i++){

            for(int j = 0 ; j < M; j++){
                if(j == 0){
//                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + map[i][j];
                }

                else if(j == M - 1){
//                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + map[i][j];
                }
                else{
//                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]),dp[i-1][j+1]) + map[i][j];
                }
            }
        }


        for(int i = 0 ; i < M; i++){
//            ans = Math.min(dp[N-1][i], ans);
        }

        for(int i = 0 ; i < N; i++){
            System.out.println();
            for(int j = 0 ; j < M; j++){
               System.out.print(dp[i][j]+ " ") ;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(N,M,map));
    }
}
