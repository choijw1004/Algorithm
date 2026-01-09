package BOJ_2667_단지번호붙이기;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static int bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        int n = map.length;
        q.offer(new int[]{x,y});
        int cnt = 1;
        while(!q.isEmpty()){
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];

            for(int i = 0 ;i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] != 0){
                    visited[nx][ny] = true;
                    cnt++;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0 ; i < n; i++){
            String s = sc.next();
            for(int j= 0; j < n ; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> s = new ArrayList<>();

        for(int i = 0 ; i <n; i++){
            for(int j = 0 ; j < n; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    s.add(bfs(i,j));
                }
            }
        }

        System.out.println(s.size());
        Collections.sort(s);

        for(int i = 0 ; i < s.size(); i++){
            System.out.println(s.get(i));
        }

    }
}
