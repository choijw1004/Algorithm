package SWEA_1861_정사각형방;

import java.util.*;

public class Solution {

    static int T;
    // 상 하 좌 우
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;
    static int[][] rooms;

    // 움직일 수 있는 최대 거리 반환 메서드
    public static int bfs(int x, int y) {
        int len = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isValidate(nx, ny) && rooms[nx][ny] - rooms[cx][cy] == 1) {
                    q.add(new int[]{nx, ny});
                    len++;
                }
            }
        }
        return len;
    }

    public static boolean isValidate(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            rooms = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = sc.nextInt();
                }
            }

            int maxLen = 0;
            int minPointValue = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int tmp = bfs(i, j);
                    if (tmp > maxLen || (tmp == maxLen && rooms[i][j] < minPointValue)) {
                        maxLen = tmp;
                        minPointValue = rooms[i][j];
                    }
                }
            }
            System.out.println("#" + tc + " " + minPointValue + " " + maxLen);
        }
    }
}
