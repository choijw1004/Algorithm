package BOJ_10026_적록색약;
import java.util.*;

public class Main {
    static int N;
    static int[][] picture;
    static boolean[][] rgbvisited;
    static boolean[][] rgvisited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int rgbCnt = 0;
    static int rgCnt = 0;

    public static void rgbfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        rgvisited[x][y] = true;
        int color = picture[x][y];

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isValid(nx, ny) && !rgvisited[nx][ny]) {
                    if ((color == 1 || color == 2) && (picture[nx][ny] == 1 || picture[nx][ny] == 2)) {
                        rgvisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    } else if (color == 3 && picture[nx][ny] == 3) {
                        rgvisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void rgbbfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        rgbvisited[x][y] = true;
        int color = picture[x][y];

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isValid(nx, ny) && !rgbvisited[nx][ny] && picture[nx][ny] == color) {
                    rgbvisited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        picture = new int[N][N];
        rgbvisited = new boolean[N][N];
        rgvisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                if (c == 'R') picture[i][j] = 1;
                else if (c == 'G') picture[i][j] = 2;
                else picture[i][j] = 3;
            }
        }

        // 적록색약이 아닌 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!rgbvisited[i][j]) {
                    rgbCnt++;
                    rgbbfs(i, j);
                }
            }
        }

        // 적록색약인 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!rgvisited[i][j]) {
                    rgCnt++;
                    rgbfs(i, j);
                }
            }
        }

        System.out.println(rgbCnt + " " + rgCnt);
    }
}
