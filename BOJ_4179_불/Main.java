package BOJ_4179_불;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static int[] ji;
    static List<int[]> fire;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static class Point{
        int x;
        int y;
        char c;

        public Point(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];
        ji = new int[2];
        fire = new ArrayList<>();

        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < R; i++){
            String line = sc.next();
            for(int j = 0; j < C; j++){
                char c = line.charAt(j);
                if(c == 'J'){
                    ji[0] = i;
                    ji[1] = j;
                }

                if(c == 'F'){
                    fire.add(new int[]{i,j});
                }
                Point point = new Point(i,j,c);
                q.offer(point);
                visited[i][j] = true;
                map[i][j] = c;
            }
        }

        while(!q.isEmpty()){
            Point curr = q.poll();

            int cx = curr.x;
            int cy = curr.y;
            int cc = curr.c;

            for(int i = 0 ; i <4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
            }
        }
    }
}
