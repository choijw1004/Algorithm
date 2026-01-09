package BOJ_1477_휴게소세우기;

import java.util.*;

public class Main {
    public static int solution(int[] point, int M, int L){
        int ans = 0;
        int N = point.length;

        int left = 1;
        int right = L;

        Arrays.sort(point);

        while(left <= right){
            int mid = (left + right) / 2;

            int cnt = 0;

            for(int i = 0; i < N - 1; i++){
                int gap = point[i+1] - point[i];
                cnt += (gap - 1) / mid;
            }

            if(cnt > M){
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int[] point = new int[N + 2];
        point[0] = 0;
        point[N + 1] = L;
        for(int i = 1; i <= N; i++){
            point[i] = sc.nextInt();
        }
        System.out.println(solution(point, M, L));
    }
}
