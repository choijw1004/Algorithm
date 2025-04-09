package BOJ_1027_고층건물;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static int solution(int[] heights){
        int maxv = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int v = 0;
            double maxR = -Double.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                double d = (heights[j] - heights[i]) / (double)(j - i);
                if (d > maxR) {
                    maxR = d;
                    v++;
                }
            }

            double maxL = -Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double d = (heights[i] - heights[j]) / (double)(i - j);
                if (d > maxL) {
                    maxL = d;
                    v++;
                }
            }

            maxv = Math.max(maxv, v);
        }
        return maxv;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(solution(heights));
    }
}
