package BOJ_5567_결혼식;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        visited[1] = true;
        dist[1] = 0;
        q.offer(1);

        while(!q.isEmpty()){
            int curr = q.poll();
            if (dist[curr] == 2) continue;

            for(int next : graph[curr]){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                }
            }
        }

        int cnt = 0;
        for(int i = 2; i <= n; i++){
            if(dist[i] == 1 || dist[i] == 2) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
