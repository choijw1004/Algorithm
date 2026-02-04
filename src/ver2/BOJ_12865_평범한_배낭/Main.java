package ver2.BOJ_12865_평범한_배낭;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = sc.nextInt();

        int[][] items = new int[n][2];
        int[] dp = new int[max + 1];
        dp[0] = 0;

        for(int i = 0;  i < n; i++){
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }

        for(int[] item : items){
            int cost = item[0];
            int weight = item[1];

            for(int j = max; j - cost >= 0; j--){
                dp[j] = Math.max(dp[j], dp[j-cost] + weight);
            }
        }
        System.out.println(dp[max]);

    }
}

/*
# 카테고리
DP, 냅색

# 접근 방식
냅색 알고리즘으로 해결했다.

# 문제 링크
https://www.acmicpc.net/problem/12865
 */

