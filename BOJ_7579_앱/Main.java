package BOJ_7579_앱;
import java.util.*;

public class Main {
    public static int solution(int target, int[] memorys, int[] costs){
        int ans = 0;
        int maxC = 0;
        int n = memorys.length;

        for(int cost : costs){
            maxC += cost;
        }

        int[] d = new int[maxC + 1];

        for(int i = 0 ; i < n; i++){
            int v = memorys[i];
            int w = costs[i];

            for(int j = maxC; j >= w; j--){
                d[j] = Math.max(d[j], d[j-w] + v);
            }
        }

        for(int i = 0; i <= maxC; i++){
            if(d[i] >= target) {
                ans = i;
                break;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] memorys = new int[n];
        int[] cost = new int[n];

        for(int i = 0 ; i < n; i++){
            memorys[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            cost[i] = sc.nextInt();
        }

        System.out.println(solution(target, memorys, cost));
    }
}
