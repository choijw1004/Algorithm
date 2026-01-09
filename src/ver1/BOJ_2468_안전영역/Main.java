package BOJ_2468_안전영역;
import java.util.*;

public class Main {
    static int N;
    static int[][] area;
    static int[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static boolean isValidate(int x, int y){
        boolean flag = false;

        if(x >= 0 && y >= 0 && x < N && y < N){
            flag = true;
        }

        return flag;
    }

    public static void bfs(int cx, int cy, int height){
        Queue<Integer> q = new LinkedList<>();
        q.add(cx);
        q.add(cy);
        visited[cx][cy] = 1;

        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();

            for(int i = 0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValidate(nx, ny) && area[nx][ny] > height && visited[nx][ny] != 1) {
                    q.add(nx);
                    q.add(ny);
                    visited[nx][ny] = 1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        area = new int[N][N];

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                int input = sc.nextInt();
                area[i][j] = input;
            }
        }

        int maxSafeArea = 0;

        for(int height = 0 ; height <= 100; height++){
            int safeArea = 0;
            visited = new int[N][N];
            for(int i = 0 ; i < N; i++){
                for(int j = 0; j < N ;j++){
                    if(visited[i][j] != 1 && area[i][j] > height){
                        bfs(i, j, height);
                        safeArea++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, safeArea);
        }

        System.out.println(maxSafeArea);

    }

}
