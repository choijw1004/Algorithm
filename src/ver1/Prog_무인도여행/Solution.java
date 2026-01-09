package Prog_무인도여행;

import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static boolean[][] visited;
    static String[] maps;

    public int bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int food = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currX = current[0];
            int currY = current[1];

            // 음식량 더하기
            food += maps[currX].charAt(currY) - '0';

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (check(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }
        return food;
    }


    public boolean check(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M && maps[x].charAt(y) != 'X');
    }

    public List<Integer> solution(String[] mapsInput) {

        int a = 1;
        List<Integer> answer = new ArrayList<>();
        maps = mapsInput;

        N = maps.length;        // 행
        M = maps[0].length();   // 열

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    answer.add(bfs(i, j));
                }
            }
        }

        if (answer.isEmpty()) {
            answer.add(-1);
        }

        Collections.sort(answer);
        return answer;
    }
}
