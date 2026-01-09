package BOJ_2660_회장뽑기;
import java.util.*;
public class Main {
    static int n;

    private static int countRelation(int start, List<Integer>[] graph){
        boolean[] visited = new boolean[n+1];
        int[] dist       = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        dist[start]    = 0;
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : graph[cur]){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    dist[nxt]    = dist[cur] + 1;
                    q.offer(nxt);
                }
            }
        }

        int score = 0;
        for(int i = 1; i <= n; i++){
            score = Math.max(score, dist[i]);
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Integer>[] g = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        while(true){
            int u = sc.nextInt(), v = sc.nextInt();
            if(u == -1 && v == -1) break;
            g[u].add(v);
            g[v].add(u);
        }

        int[] result = new int[n+1];
        int minScore = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            result[i] = countRelation(i, g);
            minScore  = Math.min(minScore, result[i]);
        }

        List<Integer> candidates = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(result[i] == minScore) candidates.add(i);
        }

        System.out.println(minScore + " " + candidates.size());
        for(int p : candidates) {
            System.out.print(p + " ");
        }
    }
}
