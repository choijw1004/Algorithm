package BOJ_4179_불;
import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    // 상하좌우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // Point 클래스: x, y 좌표와 해당 위치의 타입('J' 또는 'F')을 저장
    static class Point {
        int x, y;
        char type; // 'J': 지훈이, 'F': 불

        public Point(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 속도를 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);

        map = new char[R][C];
        Queue<Point> fireQueue = new LinkedList<>();
        Queue<Point> personQueue = new LinkedList<>();

        // 맵 입력 및 초기 큐 설정
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'F') {
                    fireQueue.offer(new Point(i, j, 'F'));
                } else if (map[i][j] == 'J') {
                    personQueue.offer(new Point(i, j, 'J'));
                }
            }
        }

        int time = 0;
        // BFS 진행: 지훈이의 탈출 여부를 판단
        while (!personQueue.isEmpty()) {
            // 1. 불 확산 처리 (같은 시간 단위 내에 동시에 확산)
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                Point fire = fireQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = fire.x + dx[d];
                    int ny = fire.y + dy[d];
                    // 경계 체크
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    // 빈 공간('.') 또는 지훈이가 있는 공간('J')이면 불 확산
                    if (map[nx][ny] == '.' || map[nx][ny] == 'J') {
                        map[nx][ny] = 'F';
                        fireQueue.offer(new Point(nx, ny, 'F'));
                    }
                }
            }

            // 2. 지훈이 이동 처리
            int personSize = personQueue.size();
            for (int i = 0; i < personSize; i++) {
                Point person = personQueue.poll();
                // 맵의 경계에 있으면 탈출 가능 (다음 시간에 탈출)
                if (person.x == 0 || person.x == R - 1 || person.y == 0 || person.y == C - 1) {
                    System.out.println(time + 1);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = person.x + dx[d];
                    int ny = person.y + dy[d];
                    // 경계 체크
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    // 이동 가능한 조건: 빈 공간('.')인 경우
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'J'; // 방문 처리: 지훈이의 이동 경로임을 표시
                        personQueue.offer(new Point(nx, ny, 'J'));
                    }
                }
            }
            time++;
        }
        // 더 이상 이동할 수 없으면 탈출 실패
        System.out.println("IMPOSSIBLE");
    }
}
