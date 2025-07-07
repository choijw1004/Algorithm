package BOJ_1167_트리의지름;
import java.util.*;

class Edge {
    int v, dist;
    Edge(int v, int dist) { this.v = v; this.dist = dist; }
}

public class Main {
    static List<Edge>[] t;
    static int[] dist;

    static void dfs(int cur, int parent) {
        for (Edge e : t[cur]) {
            if (e.v == parent) continue;
            dist[e.v] = dist[cur] + e.dist;
            dfs(e.v, cur);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        t = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) t[i] = new ArrayList<>();

        int lines = V;  // 입력 줄 수 = V
        while (lines-- > 0) {
            int u = sc.nextInt();
            while (true) {
                int v = sc.nextInt();
                if (v == -1) break;
                int w = sc.nextInt();
                t[u].add(new Edge(v, w));
            }
        }

        dist = new int[V+1];
        dfs(1, 0);
        int A = 1;
        for (int i = 2; i <= V; i++) {
            if (dist[i] > dist[A]) A = i;
        }

        dist = new int[V+1];
        dfs(A, 0);
        int diameter = 0;
        for (int i = 1; i <= V; i++) {
            diameter = Math.max(diameter, dist[i]);
        }

        System.out.println(diameter);
    }
}
