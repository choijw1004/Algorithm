package BOJ_1261_알고스팟;
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
    static int[][] grid;
    static int[][] dist;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    private static int bfs(int x, int y){
        Deque<Node> dq = new LinkedList<>();
        Node start = new Node(x,y,0);
        dq.offer(start);
        dist[0][0] = 0;

        while(!dq.isEmpty()){
            Node curr = dq.poll();
            int cx = curr.x;
            int cy = curr.y;
            int cc = curr.cost;

            for(int i = 0 ; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < n && ny < m && nx >= 0 && ny >= 0){
                    int nc = grid[nx][ny];

                    if(dist[nx][ny] > cc + nc){
                        dist[nx][ny] = cc + nc;

                        if(nc == 0) dq.offerFirst(new Node(nx,ny,cc+ nc));
                        else dq.offerLast(new Node(nx,ny,cc +nc));
                    }
                }

            }

        }
        return dist[n-1][m-1];
    }
    private static int solution(int[][] grid){
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        return bfs(0,0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        grid = new int[n][m];

        for(int i = 0 ; i < n; i++){
            String s = sc.next();
            for(int j = 0 ; j < m; j++){
                grid[i][j] = s.charAt(j) - '0';
            }
        }
        int result = solution(grid);
        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
