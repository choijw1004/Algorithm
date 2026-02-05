package ver2.BOJ_1325_효율적인_해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,v;
    static List<Integer>[] graph;
    private static int bfs(int start){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int rt = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : graph[curr]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    rt++;
                }
            }
        }
        return rt;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        v = Integer.parseInt(line[1]);

        graph = new ArrayList[n+1];

        int[] cnt = new int[n+1];
        int max = -1;

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < v; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n2].add(n1);
        }

        for(int i = 1; i <= n; i++){
            int count = bfs(i);
            cnt[i] = count;
            max = Math.max(count,max);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(cnt[i] == max) ans.add(i);
        }

        Collections.sort(ans);

        for(int i = 0 ; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }

    }
}

/*
# 카테고리
그래프, BFS

# 접근 방식
각 노드 별로 BFS를 돌려 나오는 리턴값을 비교해서 값을 출력하는 방식이다.

# 문제 링크
https://www.acmicpc.net/problem/1325
 */