package BOJ_17396_백도어;
import java.util.*;

class Edge implements Comparable<Edge> {
    int end;
    long cost;

    public Edge(int end, long cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge n) {
        return Long.compare(this.cost, n.cost);
    }
}

public class Main {
    private static void dijkstra(int start, int end, long[] dist, List<Edge>[] g, int[] canGo) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int currNode = curr.end;
            long currCost = curr.cost;

            if (currCost > dist[currNode]) continue;

            for (Edge e : g[currNode]) {
                if (e.end != end && canGo[e.end] == 1) continue;
                if (dist[e.end] > currCost + e.cost) {
                    dist[e.end] = currCost + e.cost;
                    pq.offer(new Edge(e.end, dist[e.end]));
                }
            }
        }
    }

    private static long solution(int[] canGo, List<Edge>[] g) {
        long[] dist = new long[g.length];
        Arrays.fill(dist, Long.MAX_VALUE);

        dijkstra(0, g.length - 1, dist, g, canGo);

        return dist[g.length - 1] == Long.MAX_VALUE ? -1 : dist[g.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] canGo = new int[n];
        for (int i = 0; i < n; i++) {
            canGo[i] = sc.nextInt();
        }

        ArrayList<Edge>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            g[start].add(new Edge(end, cost));
            g[end].add(new Edge(start, cost));
        }

        System.out.println(solution(canGo, g));
    }
}
