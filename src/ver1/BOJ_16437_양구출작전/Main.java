package BOJ_16437_양구출작전;
import java.util.*;
public class Main {
    static String[] type;
    static int[]    amount;
    static List<Integer>[] g;
    static int n;

    private static long dfs(int u) {
        long sum = 0;
        // 1) 자식부터 처리
        for (int v : g[u]) {
            sum += dfs(v);
        }
        if(!(u== 1)) {
            if (type[u].equals("S")) sum += amount[u];
            else sum -= amount[u];
            // 3) 음수는 0으로
        }
        return Math.max(sum, 0L);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 배열 크기 할당!
        type   = new String[n+1];
        amount = new int   [n+1];
        g      = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        // 2번부터 n번까지 입력
        for (int i = 2; i <= n; i++) {
            type[i]   = sc.next();      // "S" 또는 "W"
            amount[i] = sc.nextInt();   // 양 또는 늑대 수
            int parent = sc.nextInt();  // 부모 번호
            g[parent].add(i);           // 부모 → 자식 방향
        }

        long ans = dfs(1);  // 루트 1번에서 시작
        System.out.println(ans);
    }
}
