package BOJ_15683_감시;

import java.util.*;
public class Main {

    static class CCTV {
        int x, y, type;
        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<CCTV> cctvList = new ArrayList<>();
    static int[][][] directions = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int idx, int[][] map) {
        if (idx == cctvList.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] == 0)
                        cnt++;
                }
            }
            answer = Math.min(answer, cnt);
            return;
        }
        CCTV cur = cctvList.get(idx);
        for (int[] d : directions[cur.type]) {
            int[][] copy = copyMap(map);
            for (int dir : d) {
                int x = cur.x, y = cur.y;
                while (true) {
                    x += dx[dir];
                    y += dy[dir];
                    if (x < 0 || x >= N || y < 0 || y >= M || copy[x][y] == 6)
                        break;
                    if (copy[x][y] == 0)
                        copy[x][y] = 7;
                }
            }
            dfs(idx + 1, copy);
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] cp = new int[N][M];
        for (int i = 0; i < N; i++)
            cp[i] = Arrays.copyOf(map[i], M);
        return cp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
                if (map[i][j] >= 1 && map[i][j] <= 5)
                    cctvList.add(new CCTV(i, j, map[i][j]));
            }
        }
        dfs(0, map);
        System.out.println(answer);
    }
}

