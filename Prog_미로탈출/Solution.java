package Prog_미로탈출;
import java.util.*;

class Solution {

    static int N;
    static int M;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static String[] staticMaps;

    public int bfs(String[] maps, String target, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentT = current[2];

            if (maps[currentX].charAt(currentY) == target.charAt(0)) {
                return currentT;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (!visited[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') {
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY, currentT + 1});
                    }
                }
            }
        }

        return -1;
    }

    public int[] find(String target) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (staticMaps[i].charAt(j) == target.charAt(0)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};  // 못 찾으면 -1 반환
    }

    public int solution(String[] maps) {
        staticMaps = maps;
        N = maps.length;
        M = maps[0].length();

        visited = new boolean[N][M];
        int toL = bfs(maps, "L", find("S")[0], find("S")[1]);
        if (toL == -1) return -1;

        visited = new boolean[N][M];
        int toE = bfs(maps, "E", find("L")[0], find("L")[1]);
        if (toE == -1) return -1;

        return toL + toE;
    }
}
