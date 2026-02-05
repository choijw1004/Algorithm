# BOJ_14940_쉬운_최단거리

## 문제 링크
https://www.acmicpc.net/problem/14940

## 카테고리
`2차원 배열` `BFS` 


## 코드
```java
package ver2.BOJ_14940_쉬운_최단거리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        int[] startPoint = new int[3];

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                int p = sc.nextInt();
                if(p == 2) {
                    startPoint[0] = i;
                    startPoint[1] = j;
                    startPoint[2] = 0;
                }
                map[i][j] = p;
            }
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<int[]> q = new LinkedList<>();
        visited[startPoint[0]][startPoint[1]] = true;

        q.add(startPoint);


        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cdist = curr[2];

            for(int i = 0 ; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] != 0){
                    q.add(new int[]{nx,ny,cdist+1});
                    visited[nx][ny] = true;
                    dist[nx][ny] = cdist+1;
                }

            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0) {
                    System.out.print(0 + " ");
                }
                else if(dist[i][j] == 0 && map[i][j] == 1) {
                    System.out.print(-1 + " ");
                }
                else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
     }
}

/*
# 카테고리
2차원 배열, BFS
# 접근 방식
BFS
# 문제 링크
https://www.acmicpc.net/problem/14940
 */
```
