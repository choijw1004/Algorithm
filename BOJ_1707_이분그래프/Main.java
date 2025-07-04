package BOJ_1707_이분그래프;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- >0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<Integer>[] graph = new ArrayList[n+1];

            for(int i = 1; i<=n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

        }

    }
}
