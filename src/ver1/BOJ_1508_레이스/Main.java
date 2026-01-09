package BOJ_1508_레이스;
import java.util.*;

public class Main {
    public static String solution(int n, int m, int k, int[] points){
        int left = 0;
        int right = m;
        String ans = "";

        while(left <= right){
            int mid = (left + right) / 2;
            StringBuilder sb = new StringBuilder();
            int cnt = 0;

            for(int i = 0; i < points.length-1; i++){
                if(points[i+1] - points[i] >= mid && points[i+1] == points[i] + mid) {
                    cnt++;
                    sb.append(1);
                }
                else sb.append(0);
            }

            if(cnt >= m){
                left = mid +1;
                ans = sb.toString();
            }
            else right = mid -1;
        }

        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] points = new int[k];

        for(int i = 0 ; i < k ;i++){
            points[i]  = sc.nextInt();
        }

        System.out.println(solution(n,m,k,points));
    }
}
