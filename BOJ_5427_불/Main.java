package BOJ_5427_불;
import java.util.*;

public class Main {
    static int T, N, M;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;

    public static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M && map[x][y] != '#';
    }

    public static boolean isOut(int x, int y){
        return (x == 0 || y == 0 || x == N - 1 || y == M -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            M = sc.nextInt();
            N = sc.nextInt();
            map = new char[N][M];
            int time = 0;
            int flag = 0;

            Queue<int[]> fq = new LinkedList<>();
            Queue<int[]> sq = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < M; j++) {
                    char c = s.charAt(j);
                    map[i][j] = c;
                    if (c == '*') {
                        fq.offer(new int[]{i, j});
                    }
                    if (c == '@') {
                        sq.offer(new int[]{i, j});
                    }
                }
            }
            while (!sq.isEmpty()) {
                int fireSize = fq.size();
                for (int i = 0; i < fireSize; i++) {
                    int[] cfire = fq.poll();
                    int cfx = cfire[0];
                    int cfy = cfire[1];
                    for (int j = 0; j < 4; j++) {
                        int nfx = cfx + dx[j];
                        int nfy = cfy + dy[j];
                        if (isValid(nfx, nfy) && (map[nfx][nfy] == '@' || map[nfx][nfy] == '.')) {
                            map[nfx][nfy] = '*';
                            fq.offer(new int[]{nfx, nfy});
                        }
                    }
                }
                int sSize = sq.size();
                for (int i = 0; i < sSize; i++) {
                    int[] cs = sq.poll();
                    int csx = cs[0];
                    int csy = cs[1];
                    if (isOut(csx, csy)) {
                        flag = 1;
                        break;
                    }
                    for (int j = 0; j < 4; j++) {
                        int nsx = csx + dx[j];
                        int nsy = csy + dy[j];
                        if (isValid(nsx, nsy) && map[nsx][nsy] == '.') {
                            map[nsx][nsy] = '@';
                            sq.offer(new int[]{nsx, nsy});
                        }
                    }
                }
                if (flag == 1) {
                    break;
                }
                time++;
            }
            if (flag == 1) {
                System.out.println(time + 1);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
