package BOJ_1012_유기농배추;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N;
    static int M;
    static int cC;
    public static int solution(int[][] map, int cC){
        int cnt = 0;

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){

                if(map[i][j] == 1) {
                    if (visited[i][j]) continue;
                    else {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
        }

        return cnt;
    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0 ; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx <N && ny < M && map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx,ny});
                }
            }

        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0 ; i < T; i++){
            M = sc.nextInt();
            N = sc.nextInt();
            cC = sc.nextInt();
            map = new int[N][M];
            for(int j = 0 ; j< cC; j++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                map[x][y] = 1;
            }
            visited = new boolean[N][M];

            System.out.println(solution(map, cC));

        }
    }
}
