# BOJ_1967_트리의_지름

## 문제 링크
https://www.acmicpc.net/problem/1967

## 카테고리
`트리` `BFS` 


## 코드
```java
package ver2.BOJ_1967_트리의_지름;

import java.util.*;

class Node{
    int to;
    int w;

    public Node(int to, int w){
        this.to = to;
        this.w = w;
    }
}
public class Main {
    static int n;
    static List<Node>[] tree;

    private static int[] bfs(int start){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start,0));
        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        int max = 0;
        int point = 0;

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.w > max){
                max = curr.w;
                point = curr.to;
            }

            for(Node next : tree[curr.to]){
                if(!visited[next.to]){
                    visited[next.to] = true;
                    q.offer(new Node(next.to, curr.w + next.w));
                }
            }
        }
        return new int[]{point,max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        tree = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i < n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            tree[a].add(new Node(b,c));
            tree[b].add(new Node(a,c));
        }

        int[] p1 = bfs(1);
        int[] p2 = bfs(p1[0]);

        System.out.println(p2[1]);
    }
}

/*
# 카테고리
트리, BFS

# 접근 방식
루트에서 하나의 노드의 최장 거리를 가진 노드를 찾고, 그 노드에서부터 가장 먼거리의 노드를 찾아서 반환하는 방식으로 해결했다.
# 문제 링크
https://www.acmicpc.net/problem/1967
 */
```
