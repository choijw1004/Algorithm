package BOJ_16920_확장게임;
import java.util.*;

public class Main {
    static int p, n, m;
    static char[][] grid;
    static int[] speed;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0,};

    static void solution() {
        int[][] owner = new int[n][m];
        Queue<int[]>[] queues = new LinkedList[p + 1];
        for (int i = 1; i <= p; i++) {
            queues[i] = new LinkedList<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == '#') {
                    owner[r][c] = -1;
                } else if (Character.isDigit(grid[r][c])) {
                    int player = grid[r][c] - '0';
                    owner[r][c] = player;
                    queues[player].add(new int[]{r, c});
                }
            }
        }

        boolean moved = true;

        while (moved) {
            moved = false;

            for (int player = 1; player <= p; player++) {
                Queue<int[]> queue = new LinkedList<>();
                queue.addAll(queues[player]);

                if (queue.isEmpty()) continue;

                moved = true;

                for (int step = 1; step <= speed[player] && !queue.isEmpty(); step++) {
                    int sz = queue.size();
                    for (int i = 0; i < sz; i++) {
                        int[] cur = queue.poll();
                        int r = cur[0], c = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dx[d];
                            int nc = c + dy[d];
    
                            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                            if (owner[nr][nc] != 0) continue;

                            owner[nr][nc] = player;
                            queue.add(new int[]{nr, nc});
                        }
                    }
                }
                queues[player] = queue;
            }
        }

        int[] result = new int[p + 1];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (owner[r][c] > 0) {
                    result[owner[r][c]]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();

        speed = new int[p + 1];

        for (int i = 1; i <= p; i++) {
            speed[i] = sc.nextInt();
        }

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        solution();
    }
}

