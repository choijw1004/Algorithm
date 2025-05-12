package BOJ_2573_빙산;
import java.util.*;

public class Main {
    static int n,m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] grid;
    private static void melt(int[][] grid){
        int[][] diff = new int[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    for(int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(nx<n && ny < m && nx >= 0 && ny >= 0 && grid[nx][ny] == 0){
                            diff[i][j]++;
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                grid[i][j] -= diff[i][j];
                if(grid[i][j] <= 0) grid[i][j] = 0;
            }
        }
    }
    private static boolean allMelt(int[][] grid) {
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] > 0 ) return false;
            }
        }
        return true;
    }

    private static void bfs(int x, int y, boolean[][] visited){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx<n && ny<m && nx>=0 && ny>=0){
                    if(!visited[nx][ny] && grid[nx][ny] != 0){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }

    }
    private static int countIsland(int[][] grid){
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(!visited[i][j] && grid[i][j] != 0){
                    cnt++;
                    bfs(i,j,visited);
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        if (countIsland(grid) >= 2) {
            System.out.println(0);
            return;
        }

        int time = 0;

        while (true) {
            melt(grid);
            time++;

            if (countIsland(grid) >= 2) {
                System.out.println(time);
                break;
            }
            if (allMelt(grid)) {
                System.out.println(0);
                break;
            }
        }
    }
}
