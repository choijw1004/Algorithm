package ver2.BOJ_카우버거알바생;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[m + 1][k + 1];
        dp[0][0] = 0;

        int[][] items = new int[n][2];

        for(int i = 0; i < n; i++){
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }

        for(int[] item : items){
            int a = item[0];
            int b = item[1];

            for(int x = m; x - a >= 0; x--){
                for(int y = k; y - b >=0; y--){
                    dp[x][y] = Math.max(dp[x][y], dp[x-a][y-b] + 1);
                }
            }
        }

        System.out.println(dp[m][k]);


    }
}
