package BOJ_10800_컬러볼;
import java.util.*;

public class Main {
    public static int solution(int[][] balls){
        int ans = 0;
        int n = balls.length;

        Arrays.sort(balls, (a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            else return a[0] - b[0];
        });




        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] balls = new int[n][2];

        for(int i = 0 ; i < n; i++){
            balls[i][0] = sc.nextInt();
            balls[i][1] = sc.nextInt();
        }

        System.out.println(solution(balls));

    }
}
