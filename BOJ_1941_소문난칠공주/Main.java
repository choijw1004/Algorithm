package BOJ_1941_소문난칠공주;
import java.util.*;

public class Main {
    static char[][] map;
    static int result = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String s = sc.next();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        // 조합을 위한 백트래킹: 인덱스 0부터 24까지, 현재 선택 개수 0, 'S' 개수 0, 선택된 인덱스 저장할 리스트
        select(0, 0, 0, new ArrayList<>());
        System.out.println(result);
    }

    // idx: 현재 고려하는 인덱스 (0 ~ 24)
    // cnt: 지금까지 선택한 칸의 개수
    // sCount: 선택된 칸 중 'S'의 개수
    // selected: 현재 선택된 칸들의 인덱스 리스트
    static void select(int idx, int cnt, int sCount, List<Integer> selected) {
        if (cnt == 7) { // 7개의 칸을 선택한 경우
            // 'S'가 4명 이상이고 선택한 좌표들이 모두 연결되어 있으면
            if (sCount >= 4 && isConnected(selected)) {
                result++;
            }
            return;
        }
        if (idx >= 25) return; // 범위를 벗어나면 리턴

        // 현재 인덱스를 선택하는 경우
        selected.add(idx);
        int r = idx / 5; // 1차원 인덱스를 행으로 변환
        int c = idx % 5; // 1차원 인덱스를 열로 변환
        if (map[r][c] == 'S') {
            select(idx + 1, cnt + 1, sCount + 1, selected);
        } else {
            select(idx + 1, cnt + 1, sCount, selected);
        }
        selected.remove(selected.size() - 1);

        // 현재 인덱스를 선택하지 않는 경우
        select(idx + 1, cnt, sCount, selected);
    }

    // 선택된 7개의 좌표가 상하좌우로 모두 연결되어 있는지 확인하는 함수 (BFS를 사용)
    static boolean isConnected(List<Integer> selected) {
        boolean[][] selectedMap = new boolean[5][5];
        for (int idx : selected) {
            int r = idx / 5;
            int c = idx % 5;
            selectedMap[r][c] = true;
        }

        boolean[][] visited = new boolean[5][5];
        // 선택된 좌표 중 첫 번째 좌표에서 탐색 시작
        int start = selected.get(0);
        int startR = start / 5;
        int startC = start % 5;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 &&
                        selectedMap[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                    count++;
                }
            }
        }
        return count == 7;
    }
}
