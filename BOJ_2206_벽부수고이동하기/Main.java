package BOJ_2206_벽부수고이동하기;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0}); // (x, y, 벽 부숨 여부)
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], breakWall = now[2];

            if (x == N - 1 && y == M - 1) return visited[x][y][breakWall];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽을 부수지 않고 방문 가능
                if (map[nx][ny] == 0 && visited[nx][ny][breakWall] == 0) {
                    visited[nx][ny][breakWall] = visited[x][y][breakWall] + 1;
                    q.offer(new int[]{nx, ny, breakWall});
                }

                // 벽을 부수고 방문 가능 (벽을 한 번도 부수지 않은 상태여야 함)
                if (map[nx][ny] == 1 && breakWall == 0 && visited[nx][ny][1] == 0) {
                    visited[nx][ny][1] = visited[x][y][breakWall] + 1;
                    q.offer(new int[]{nx, ny, 1});
                }
            }
        }

        return -1; // 도착 불가능한 경우
    }
}
