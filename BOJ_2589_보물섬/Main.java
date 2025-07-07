package BOJ_2589_보물섬;

import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    // 동서남북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // (sr,sc)에서 BFS를 돌려서 최대 거리 리턴
    private static int bfs(int sr, int sc) {
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        visited[sr][sc] = true;
        q.offer(new int[]{sr, sc});
        int maxDist = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'W') continue;  // 바다면 건너뛴다

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                maxDist = Math.max(maxDist, dist[nx][ny]);
                q.offer(new int[]{nx, ny});
            }
        }

        return maxDist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        int answer = 0;
        // 모든 육지(L)에서 BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
        sc.close();
    }
}
