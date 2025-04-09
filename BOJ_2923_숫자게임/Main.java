package BOJ_2923_숫자게임;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        long score = a[0] + b[0];
        int aidx = 0, bidx = 0;
        int maxa = a[0], maxb = b[0];

        for (int move = 0; move < n - 1; move++) {
            long optA = Long.MIN_VALUE, optB = Long.MIN_VALUE;

            if (aidx + 1 < n) {
                optA = (long)maxb + a[aidx + 1];
            }
            if (bidx + 1 < n) {
                optB = (long)maxa + b[bidx + 1];
            }

            if (optA >= optB) {
                aidx++;
                score += maxb + a[aidx];
                maxa = Math.max(maxa, a[aidx]);
            } else {
                bidx++;
                score += maxa + b[bidx];
                maxb = Math.max(maxb, b[bidx]);
            }
        }

        System.out.println(score);
    }
}
