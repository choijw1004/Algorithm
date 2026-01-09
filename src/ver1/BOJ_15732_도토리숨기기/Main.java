package BOJ_15732_도토리숨기기;

import java.util.*;

public class Main {
    static class Rule {
        int A, B, C;
        Rule(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int D = sc.nextInt();
        List<Rule> rules = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            rules.add(new Rule(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        sc.close();

        int left = 1, right = N;
        while (left < right) {
            int mid = left + (right - left) / 2;

            long cnt = 0;
            for (Rule rule : rules) {
                if (mid < rule.A) continue;
                int lastPos = Math.min(mid, rule.B);
                cnt += (long)(lastPos - rule.A) / rule.C + 1;
                if (cnt >= D) break;
            }

            if (cnt >= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
