package BOJ_2423_전구를켜라;
import java.util.*;

class Node{
    int x,y,cost;
    public Node(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
public class Main {
    static int n,m;
    static int[][] grid,dist;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};


    private static int bfs(int sx, int sy){
        Deque<Node> dq = new LinkedList<>();
        dq.offer(new Node(sx,sy,0));
        dist[sx][sy] = 0;

        while(!dq.isEmpty()){
            Node curr = dq.poll();
            int cx = curr.x;
            int cy = curr.y;
            int cc = curr.cost;

            for(int i = 0 ; i < 8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){





                    if(dist[nx][ny] > cc + grid[nx][ny]){
                        dist[nx][ny] = cc + grid[nx][ny];
                        if(grid[cx][cy] != grid[nx][ny]) dq.offerFirst(new Node(nx,ny,cc + grid[nx][ny]));
                        else dq.offerLast(new Node(nx,ny, cc + grid[nx][ny]));
                    }

                }

            }
        }
        return dist[n-1][m-1];

    }
    private static int solution(int[][] grid){
        dist = new int[n][m];
        for(int i = 0 ; i <n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        return bfs(0,0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for(int i = 0 ; i < n; i++){
            String s = sc.next();
            for(int j = 0 ; j < m; j++){
                char c = s.charAt(j);
                if(c == '/') grid[i][j]=1;
                else grid[i][j] = 0;
            }
        }
        int ans = solution(grid);
        System.out.println(ans == Integer.MAX_VALUE ? "NO SOLUTION" : ans);
    }
}
