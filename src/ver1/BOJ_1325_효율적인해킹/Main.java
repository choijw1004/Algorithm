package BOJ_1325_효율적인해킹;
import java.util.*;

public class Main {
    static int n;

    private static int bfs(int start, List<Integer>[] g){
        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : g[curr]){
                if(!visited[next]){
                    visited[next] = true;
                    cnt++;
                    q.offer(next);
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] g = new ArrayList[n+1];

        for(int i = 1; i <=n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; i++){
            int u = sc.nextInt();
            int v= sc.nextInt();
            g[v].add(u);
        }

        int[] result = new int[n+1];
        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i<=n; i++){
            int rt = bfs(i,g);
            max = Math.max(rt,max);
            result[i] = rt;
        }

        for(int i = 1; i<=n; i++){
            if(result[i] == max) ans.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int x : ans) {
            sb.append(x +" ");
        }
        System.out.println(sb.toString().trim());
    }
}
