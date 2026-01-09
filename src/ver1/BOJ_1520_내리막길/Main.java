package BOJ_1520_내리막길;
import java.util.*;

public class Main {
    static int[][] grid,d;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n,m;

    private static int solution(int[][] grid){
        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], -1);
        }

        return dfs(0,0);
    }

    private static int dfs(int x, int y){
        if(x == n-1 && y == m-1) return 1;
        if(d[x][y] != -1) return d[x][y];

        d[x][y] = 0;

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] < grid[x][y]) d[x][y] += dfs(nx,ny);
        }

        return d[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(grid));
    }
}
