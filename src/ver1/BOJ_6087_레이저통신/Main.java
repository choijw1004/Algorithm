package BOJ_6087_레이저통신;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    static ArrayList<int[]> lasers;
    static int[][][] visited;

    public static int bfs() {
        //우선순위 없이 q.offer 한 경우 57퍼 반례 틀
        Deque<int[]> q = new ArrayDeque<>();

        int sx = lasers.get(0)[0], sy = lasers.get(0)[1];
        int ex = lasers.get(1)[0], ey = lasers.get(1)[1];

        for (int d = 0; d < 4; d++) {
            int nx = sx + dx[d];
            int ny = sy + dy[d];

            if (isValid(nx, ny) && map[nx][ny] != '*') {
                q.offer(new int[]{nx, ny, d, 0});
                visited[nx][ny][d] = 0;
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0], cy = now[1], dir = now[2], mirror = now[3];

            if (cx == ex && cy == ey) {
                return mirror;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int newMirror = mirror;

                if (dir != d) {
                    newMirror++;
                }

                while (isValid(nx, ny) && map[nx][ny] != '*') {
                    if (visited[nx][ny][d] > newMirror) {
                        visited[nx][ny][d] = newMirror;

                        if (dir == d) {
                            q.addFirst(new int[]{nx, ny, d, newMirror});
                        }
                        else {
                            q.addLast(new int[]{nx, ny, d, newMirror});
                        }
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        map = new char[N][M];
        lasers = new ArrayList<>();
        visited = new int[N][M][4];

        for(int i = 0 ; i < N; i++){
            String line = sc.next();
            for(int j = 0 ; j < M; j++){
                char c = line.charAt(j);
                map[i][j] = c;

                if (c == 'C') {
                    lasers.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        System.out.println(bfs());
    }
}
