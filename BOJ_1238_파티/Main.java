package BOJ_1238_파티;

import java.util.*;

class Edge {
    int to, cost;
    Edge(int to, int cost) { this.to = to; this.cost = cost; }
}

public class Main {
    static final int INF = 1_000_000_000;
    static int n, m, X;
    static List<Edge>[] g, rg;

    static int[] dijkstra(List<Edge>[] graph, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[start] = 0;
        pq.offer(new int[]{0, start}); // {cost, node}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > dist[u]) continue; // 이미 더 좋은 경로가 있음

            for (Edge e : graph[u]) {
                int v = e.to;
                int nd = d + e.cost;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        X = sc.nextInt();

        g  = new ArrayList[n + 1];
        rg = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            g[u].add(new Edge(v, c));   // 원본
            rg[v].add(new Edge(u, c));  // 역그래프 (u<-v)
        }

        // X에서 모든 정점으로 (돌아가는 길)
        int[] fromX = dijkstra(g, X);
        // 모든 정점에서 X로 (가는 길) == 역그래프에서 X->i
        int[] toX = dijkstra(rg, X);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int total = toX[i] + fromX[i];
            if (total >= INF) continue; // 도달 불가한 경우 스킵(문제상 보통 연결되어 있음)
            ans = Math.max(ans, total);
        }
        System.out.println(ans);
    }
}
