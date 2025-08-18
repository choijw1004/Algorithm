package BOJ_1949_우수마을;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] dp;
    static List<Integer>[] tree;
    static int[] amount;
    static boolean[] visited;

    private static void dfs(int start){
        int am = amount[start];

        for(int v : tree[start]){
            if(visited[v]) continue;
            dfs(v);
            dp[start][0] += Math.max(dp[v][0], dp[v][1]);
            dp[start][1] += dp[v][0];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        amount = new int[n+1];
        dp = new int[n+1][2];
        visited = new boolean[n+1];

        for(int i = 0 ; i <=n;i++){
            amount[i] = sc.nextInt();
        }

        tree = new ArrayList[n+1];

        for(int i = 0 ; i <= n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0 ; i <n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));

    }
}
