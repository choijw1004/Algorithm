package BOJ_1753_최단경로;
import java.util.*;

class Edge implements Comparable<Edge>{
    int end;
    int cost;

    public Edge(int to, int cost){
        this.end = to;  // 수정: to로 할당
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge n){
        return this.cost - n.cost;
    }
}

public class Main {
    public static int dijkstra(int start, int end, ArrayList<Edge>[] g){
        int[] dist = new int[g.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;  // 시작 정점의 비용을 0으로 초기화

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currNode = curr.end;
            int curCost = curr.cost;

            if(curCost > dist[currNode]) continue;
            if(currNode == end) break;

            for(Edge e : g[currNode]){
                if(dist[e.end] > curCost + e.cost){
                    dist[e.end] = curCost + e.cost;
                    pq.offer(new Edge(e.end, dist[e.end]));
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int start = sc.nextInt();

        ArrayList<Edge>[] g = new ArrayList[vertexCount + 1];

        for(int i = 1; i <= vertexCount; i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 0; i < edgeCount; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int c = sc.nextInt();
            g[from].add(new Edge(to, c));
        }

        // 모든 정점에 대해 다익스트라 실행 (여기서는 1부터 vertexCount까지 출력)
        for(int i = 1; i <= vertexCount; i++){
            int ans = dijkstra(start, i, g);
            System.out.println(ans == Integer.MAX_VALUE ? "INF" : ans);
        }
    }
}
