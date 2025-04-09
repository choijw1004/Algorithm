package BOJ_15649_NM1;
import java.util.*;

public class Main {

    // 백트래킹 재귀 메서드
    private static void backtrack(int n, int m, List<Integer> perm, boolean[] used) {
        if (perm.size() == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : perm) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;

            perm.add(i);
            used[i] = true;

            backtrack(n, m, perm, used);

            perm.remove(perm.size() - 1);
            used[i] = false;
        }
    }

    private static void solution(int n, int m) {
        List<Integer> perm = new ArrayList<>();
        boolean[] used = new boolean[n + 1];

        backtrack(n, m, perm, used);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        solution(n, m);
    }
}
