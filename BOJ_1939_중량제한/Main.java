package BOJ_1939_중량제한;
import java.util.*;
class Edge{
    int to;
    long max;

    public Edge(int to, long max){
        this.to = to;
        this.max = max;
    }
}

public class Main {
    private static boolean canGo(int start, int end, long mid, List<List<Edge>> g){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[g.size()];
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == end ) return true;

            for(Edge e: g.get(curr)){
                if(!visited[e.to] && e.max >= mid){
                    visited[e.to] = true;
                    q.add(e.to);
                }
            }
        }
        return false;
    }
    private static long solution(List<List<Edge>> g, int[] startEnd, long right){
        long left = 1;
        int start = startEnd[0];
        int end = startEnd[1];
        long ans = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            if(canGo(start,end,mid,g)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Edge>> g = new ArrayList<>();
        long right = -1;
        for(int i = 0 ; i < n+1; i++) g.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            long mx = sc.nextLong();
            right = Math.max(mx, right);

            g.get(from).add(new Edge(to, mx));
            g.get(to).add(new Edge(from,mx));
        }

        int[] startEnd = new int[]{sc.nextInt(), sc.nextInt()};

        System.out.println(solution(g, startEnd, right));
    }
}
