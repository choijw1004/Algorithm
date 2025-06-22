package BOJ_4991_로봇청소기;
import java.util.*;

public class Main {
    static int r,c,startR,startC;
    static char[][] grid;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0,};
    private static int solution(){
        int ans = 0;


        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            r = sc.nextInt();
            c = sc.nextInt();
            if(r == 0 && c == 0 ) break;

            grid = new char[r][c];

            for(int i = 0 ; i < r; i++){
                String s = sc.next();
                for(int j = 0 ; j < c; j++){
                    char tmp = s.charAt(j);
                    if(tmp == 'o'){
                        startR = i;
                        startC = j;
                    }
                    grid[i][j] = s.charAt(tmp);
                }
            }
            System.out.println(solution());
        }
    }
}
