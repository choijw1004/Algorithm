package SWEA_7733_치즈도둑;

import java.util.*;

public class Solution {
    static int N;
    static int[][] cheese;
    static boolean[][] visited;

    // 상 하 좌 우
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void bfs(int cx, int cy, int canEat) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cx, cy});
        visited[cx][cy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValidate(nx, ny) && !visited[nx][ny] && cheese[nx][ny] > canEat) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean isValidate(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            cheese = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }

            int maxChunks = 0;

            // canEat 기준으로 갉아먹힌 칸 제외하고 덩어리 계산
            for (int canEat = 0; canEat <= 100; canEat++) {
                visited = new boolean[N][N];
                int chunks = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        // 방문하지 않았고, canEat보다 큰 치즈만 탐색
                        if (!visited[i][j] && cheese[i][j] > canEat) {
                            bfs(i, j, canEat);
                            chunks++;
                        }
                    }
                }

                maxChunks = Math.max(maxChunks, chunks);
            }

            System.out.println("#" + tc + " " + maxChunks);
        }
    }
}
