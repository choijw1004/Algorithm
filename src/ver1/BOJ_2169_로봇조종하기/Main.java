package BOJ_2169_로봇조종하기;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // dp 배열: (i, j)까지의 최대 합
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];

        // 첫 행 초기화 (왼쪽에서만 이동 가능)
        for (int j = 1; j < m; j++){
            dp[0][j] = dp[0][j-1] + map[0][j];
        }

        // 두 번째 행부터 처리
        for (int i = 1; i < n; i++){
            int[] left = new int[m];
            int[] right = new int[m];

            // 왼쪽에서 오른쪽으로 이동하면서 최대값 계산
            left[0] = dp[i-1][0] + map[i][0];
            for (int j = 1; j < m; j++){
                left[j] = Math.max(left[j-1], dp[i-1][j]) + map[i][j];
            }

            // 오른쪽에서 왼쪽으로 이동하면서 최대값 계산
            right[m-1] = dp[i-1][m-1] + map[i][m-1];
            for (int j = m - 2; j >= 0; j--){
                right[j] = Math.max(right[j+1], dp[i-1][j]) + map[i][j];
            }

            // 현재 행의 dp값은 양쪽 방향 중 최댓값을 선택
            for (int j = 0; j < m; j++){
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
}
