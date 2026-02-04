package ver2.BOJ_1976;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n,m;
    static List<Integer>[] graph;
    static int[] parent;

    private static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            parent[rootY] = parent[rootX];
        }
    }
    private static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n + 1];

        for(int i = 0 ; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int c = sc.nextInt();
                if(c == 1) graph[i].add(j);
            }
        }

        parent = new int[n + 1];

        for(int i = 1; i <=n ;i++){
            parent[i] = i;
        }

        for(int i = 1; i <= n; i++){
            for(int next : graph[i]){
                union(i,next);
            }
        }

        int[] plan = new int[m];

        boolean ans = true;

        for(int i = 0 ; i < m; i++){
            plan[i] = sc.nextInt();
        }

        for(int i = 0 ; i < m; i++){
            if(find(plan[i]) != find(plan[0])){
                ans = false;
                break;
            }
        }

        System.out.println(ans == true ? "YES" : "NO");
    }
}
