package BOJ_2617_구슬찾기;
import java.util.*;

public class Main {
    static int n,m;

    private static int dfs(int start, List<Integer>[] graph, boolean[] visited){
        visited[start] = true;
        int cnt = 0;

        for(int next : graph[start]){
            if(!visited[next]){
                visited[next] = true;
                cnt++;
                cnt += dfs(next, graph, visited);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        List<Integer>[] hi = new ArrayList[n+1];
        List<Integer>[] lo = new ArrayList[n+1];
        int mid = (n+1) / 2;
        int cnt = 0;

        for(int i = 1; i<=n;i++){
            hi[i] = new ArrayList<>();
            lo[i] = new ArrayList<>();
        }

        for(int i = 1; i<=m; i++){
            int h = sc.nextInt();
            int l = sc.nextInt();
            hi[h].add(l);
            lo[l].add(h);
        }
        for(int i = 1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            if(dfs(i,hi,visited) >= mid) {
                cnt++;
                continue;
            }

            visited = new boolean[n+1];
            if(dfs(i,lo,visited) >= mid) {
                cnt++;
                continue;
            }
        }
        System.out.println(cnt);
    }
}
