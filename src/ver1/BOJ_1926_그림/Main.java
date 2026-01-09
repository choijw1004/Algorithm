package BOJ_1926_그림;
import java.util.*;

public class Main {
    static int N,M,picC,maxV;
    static int[][] pictures;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M && pictures[x][y] == 1 && visited[x][y] == false;
    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int size = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0 ; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(isValid(nx,ny)){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    size+=1;
                }
            }
        }

        return size;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        pictures = new int[N][M];
        visited = new boolean[N][M];
        picC = 0;
        maxV = Integer.MIN_VALUE;

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                pictures[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(pictures[i][j] == 0){
                    continue;
                }

                if(!visited[i][j]){
                    picC++;
                    maxV = Math.max(maxV,bfs(i,j));
                }

            }
        }
        if(picC == 0){
            maxV = 0;
        }
        System.out.println(picC);
        System.out.println(maxV);
    }
}
