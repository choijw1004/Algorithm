package BOJ_18427_함께블록쌓기;

import java.util.*;

public class Main {
    static int N, M, H;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> stuBlocks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> blocks = new ArrayList<>();
            String[] blockHeights = sc.nextLine().split(" ");

            for (String height : blockHeights) {
                int tmp = Integer.parseInt(height);
                blocks.add(tmp);
            }
            stuBlocks.add(blocks);
        }

        int[][] DP = new int[N + 1][H + 1];
        DP[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= H; j++) {
                DP[i][j] = DP[i - 1][j];

                for (int k : stuBlocks.get(i - 1)) {
                    if (j >= k) {
                        DP[i][j] += DP[i - 1][j - k];
                        DP[i][j] %= 10007;
                    }
                }
            }
        }

        System.out.println(DP[N][H]);
    }
}
