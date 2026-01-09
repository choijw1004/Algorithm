package BOJ_13031_쉽게행복한나무;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge {
    int v;
    long w;
    public Edge(int v, long w) {
        this.v = v;
        this.w = w;
    }
}

public class Main {
    static int n;
    static long removed;
    static List<Edge>[] tree;
    static long[] a;

    static void dfs(int u, int p, long d, long minD) {
        if (d - minD > a[u]) {
            removed += countSubTrees(u, p);
            return;
        }
        long nextMin = Math.min(minD, d);
        for (Edge e : tree[u]) {
            if (e.v == p) continue;
            dfs(e.v, u, d + e.w, nextMin);
        }
    }

    static int countSubTrees(int u, int p){
        int cnt = 1;
        for (Edge e : tree[u]) {
            if (e.v == p) continue;
            cnt += countSubTrees(e.v, u);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        removed = 0;

        a = new long[n + 1];
        for (int i = 1; i <= n; i++) a[i] = sc.nextLong();

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int u = 2; u <= n; u++) {
            int p = sc.nextInt();
            long w = sc.nextLong();
            tree[p].add(new Edge(u, w));
            tree[u].add(new Edge(p, w));
        }

        dfs(1, 0, 0L, 0L);

        System.out.println(removed);
    }
}
