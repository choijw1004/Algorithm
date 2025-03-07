package BOJ_1449_수리공항승;
import java.util.*;

public class Main {
    public static int solution(int[] points, int L){
        int ans = 1;
        int n = points.length;
        Arrays.sort(points);

        double end = points[0] - 0.5 + L;

        for(int i = 1; i < n; i++){
            if(points[i] > end){
                ans++;
                end = points[i] - 0.5 + L;
            }
        }


        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        int[] points = new int[N];

        for(int i = 0 ; i < N; i++){
            points[i] = sc.nextInt();
        }

        System.out.println(solution(points, L));
    }

}
