package BOJ_14938_서강그라운드;
import java.util.*;

class Node{
    int to, cost;

    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
    static int n,m;
    static int[] items;

    private static int dijkstra(int startNode, List<List<Node>> g){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new Node(startNode, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int currNode = curr.to;
            int currCost = curr.cost;

            if(currCost > dist[currNode]) continue;

            for(Node nextNode : g.get(currNode)){
                if(dist[nextNode.to] > nextNode.cost + currCost){
                     dist[nextNode.to] = nextNode.cost + currCost;
                     pq.offer(new Node(nextNode.to, nextNode.cost + currCost));
                }
            }
        }

        int cnt = 0;
        cnt += items[startNode -1];

        for(int i = 1; i < n+1; i++){
            if(i == startNode) continue;

            if(dist[i] <= m) cnt += items[i-1];
        }

        return cnt;
    }
    private static int solution(List<List<Node>> g){
        int ans = Integer.MIN_VALUE;

        for(int i = 1; i < n+1; i++) ans = Math.max(ans, dijkstra(i,g));

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int r = sc.nextInt();
        items = new int[n];
        List<List<Node>> g = new ArrayList<>();

        for(int i = 0 ; i < n; i++) items[i] = sc.nextInt();

        for(int i =  0 ; i < n+1; i++) g.add(new ArrayList<>());

        for(int i = 0 ; i < r; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            g.get(a).add(new Node(b,c));
            g.get(b).add(new Node(a,c));
        }

        System.out.println(solution(g));
    }
}
