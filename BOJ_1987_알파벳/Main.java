package BOJ_1987_알파벳;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static char[][] grid;
    static int ans = -1;

    private static void dfs(int cx, int cy, List<Character> list, int count){
        ans = Math.max(count, ans);

        for(int i = 0 ; i < 4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(list.contains(grid[nx][ny])) continue;

                list.add(grid[nx][ny]);
                dfs(nx,ny,list,count+1);
                list.remove(list.size()-1);
            }
        }
    }
    private static int solution(char[][] grid){
        List<Character> list = new ArrayList<>();
        list.add(grid[0][0]);
        dfs(0,0,list,1);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][m];

        for(int i =  0 ; i < n; i++){
            String s = sc.next();
            for(int j = 0 ; j < m; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        System.out.println(solution(grid));
    }
}
