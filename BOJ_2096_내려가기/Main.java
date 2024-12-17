package BOJ_2096_내려가기;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] scores;

    public static int calcuMax() {
        int[] dp = new int[3];
        int[] temp = new int[3];

        for (int j = 0; j < 3; j++) {
            dp[j] = scores[0][j];
        }

        for (int i = 1; i < N; i++) {
            temp[0] = scores[i][0] + Math.max(dp[0], dp[1]);
            temp[1] = scores[i][1] + Math.max(dp[0], Math.max(dp[1], dp[2]));
            temp[2] = scores[i][2] + Math.max(dp[1], dp[2]);

            for (int j = 0; j < 3; j++) {
                dp[j] = temp[j];
            }
        }

        return Math.max(dp[0], Math.max(dp[1], dp[2]));
    }

    public static int calcuMin() {
        int[] dp = new int[3];
        int[] temp = new int[3];

        for (int j = 0; j < 3; j++) {
            dp[j] = scores[0][j];
        }

        for (int i = 1; i < N; i++) {
            temp[0] = scores[i][0] + Math.min(dp[0], dp[1]);
            temp[1] = scores[i][1] + Math.min(dp[0], Math.min(dp[1], dp[2]));
            temp[2] = scores[i][2] + Math.min(dp[1], dp[2]);

            for (int j = 0; j < 3; j++) {
                dp[j] = temp[j];
            }
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        scores = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = sc.nextInt();
            }
        }

        int maxNum = calcuMax();
        int minNum = calcuMin();

        System.out.println(maxNum + " " + minNum);
    }
}
