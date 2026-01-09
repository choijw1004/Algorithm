package BOJ_13549_숨바꼭질3;

import java.util.*;

class Node {
    int x, cost;
    public Node(int x, int cost){
        this.x = x;
        this.cost = cost;
    }
}

public class Main {
    static final int MAX = 100000;
    static int[] dist;

    private static int bfs(int start, int end) {
        dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Node> dq = new LinkedList<>();

        dist[start] = 0;
        dq.offer(new Node(start, 0));

        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            int cx = cur.x;
            int cc = cur.cost;

            if(cx == end) continue;

            int nx = cx * 2;
            if(nx <= MAX && dist[nx] > cc) {
                dist[nx] = cc;
                dq.offerFirst(new Node(nx, cc));
            }

            int[] walk = {cx - 1, cx + 1};
            for (int next : walk) {
                if(next >= 0 && next <= MAX && dist[next] > cc + 1) {
                    dist[next] = cc + 1;
                    dq.offerLast(new Node(next, cc + 1));
                }
            }
        }

        return dist[end];
    }

    private static int solution(int start, int end){
        return bfs(start, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(solution(start, end));
    }
}
