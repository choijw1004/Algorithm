package ver2.BOJ_2644_촌수계산;

import java.util.*;

public class Main {
    static int n,v,start,end,ans;
    static List<Integer>[] graph;

    private static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        int cnt = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size; i++) {
                int curr = q.poll();
                if(curr == end) return cnt;
                for (int next : graph[curr]) {
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        v = sc.nextInt();

        graph = new ArrayList[n+1];

        for(int i = 1; i<= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < v; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }


        System.out.println(bfs(start));

    }
}
