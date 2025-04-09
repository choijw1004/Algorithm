package BOJ_2613_숫자구슬;
import java.util.*;

public class Main {
    public static int solution(int m, int[] balls){
        int ans = 0;
        int r = 0;
        int l = -1;

        for(int b : balls){
            r += b;
            l = Math.max(l, b);
        }

        while(l <= r){
            int mid = (l + r) / 2;
            int curr = 0;
            int cnt = 1;
            for(int b : balls){
                if(curr + b > mid){
                    cnt++;
                    curr = b;
                }
                else curr += b;
            }

            if(cnt <= m){
                ans = mid;
                r = mid -1;
            }
            else l = mid + 1;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] balls = new int[n];

        for(int i = 0 ; i < n; i++){
            balls[i] = sc.nextInt();
        }

        System.out.println(solution(m, balls));
    }

}
