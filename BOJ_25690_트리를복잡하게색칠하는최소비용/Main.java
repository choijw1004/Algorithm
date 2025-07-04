package BOJ_25690_트리를복잡하게색칠하는최소비용;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] t;
    static int[] wCost, bCost;
    static long[][] dp;


    private static void dfs(int start, int parent){
        dp[start][0] = wCost[start];
        dp[start][1] = bCost[start];

        for(int next : t[start]){
            if(next == parent) continue;

            dfs(next, start);
            dp[start][0] += Math.min(dp[next][0], dp[next][1]);
            dp[start][1] += dp[next][0];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new ArrayList[n];
        wCost = new int[n];
        bCost = new int[n];
        dp = new long[n][2];

        for(int i = 0 ; i < n; i++){
            t[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            t[u].add(v);
            t[v].add(u);
        }

        for(int i = 0 ; i < n; i++){
            wCost[i] = sc.nextInt();
            bCost[i] = sc.nextInt();
        }

        dfs(0,-1);

        System.out.println(Math.min(dp[0][0], dp[0][1]));
    }
}
