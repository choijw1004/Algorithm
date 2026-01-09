package BOJ_2258_정육점;

import java.util.*;

public class Main {
    private static int solution(int n, int m, int[][] meats) {
        int total = 0;
        int weightSum = 0;
        int priceSum = 0;
        int prePrice = -1;
        int minCost = Integer.MAX_VALUE;

        Arrays.sort(meats, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) {
            total += meats[i][0];
        }

        if (total < m) {
            return -1;
        }

        for (int[] cur : meats) {
            weightSum += cur[0];
            if (cur[1] != prePrice) {
                prePrice  = cur[1];
                priceSum = cur[1];
            } else {
                priceSum += cur[1];
            }
            if (weightSum >= m) {
                minCost = Math.min(minCost, priceSum);
            }
        }

        return minCost;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] meats = new int[n][2];
        for (int i = 0; i < n; i++) {
            meats[i][0] = sc.nextInt();
            meats[i][1] = sc.nextInt();
        }

        System.out.println(solution(n, m, meats));
    }
}