package BOJ_1303_전투;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static char[][] map;
    public static int bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        int cnt =1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            char team = map[cx][cy];

            for(int i = 0 ; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >=0 && ny >=0 && nx < map.length && ny < map[0].length){
                    if(map[nx][ny] == team && !visited[nx][ny]){
                        cnt++;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
            }
        }

        int w = 0;
        int b = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]) {
                    int p = bfs(i,j);
                    if(map[i][j] == 'W') w += p*p;
                    else b += p*p;
                }
            }
        }
        System.out.println(w + " " + b);
    }
}
