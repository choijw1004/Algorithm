package BOJ_17142_연구소3;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] grid;
    static List<List<int[]>> tmpViruses = new ArrayList<>();

    private static void comb(List<int[]> viruses, int idx, List<int[]> curr) {
        if (curr.size() == m) {
            tmpViruses.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i < viruses.size(); i++) {
            curr.add(viruses.get(i));
            comb(viruses, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    private static int bfs(List<int[]> active, int emptyCnt) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        int filled = 0, maxTime = 0;

        for (int[] v : active) {
            visited[v[0]][v[1]] = true;
            q.offer(new int[] {v[0], v[1], 0});
        }

        while (!q.isEmpty() && filled < emptyCnt) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], t = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || grid[nx][ny] == 1) continue;

                visited[nx][ny] = true;

                if (grid[nx][ny] == 0) {
                    filled++;
                    maxTime = t + 1;
                }

                q.offer(new int[] {nx, ny, t + 1});
            }
        }
        return (filled == emptyCnt) ? maxTime : -1;
    }

    private static int solution(int[][] grid, List<int[]> viruses) {
        comb(viruses, 0, new ArrayList<>());
        int emptyCnt = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) emptyCnt++;
            }
        }

        for (List<int[]> active : tmpViruses) {
            int time = bfs(active, emptyCnt);
            if (time != -1) {
                answer = Math.min(answer, time);
            }
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        List<int[]> viruses = new ArrayList<>();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) viruses.add(new int[] {i, j});
            }
        }

        System.out.println(solution(grid, viruses));
    }
}
