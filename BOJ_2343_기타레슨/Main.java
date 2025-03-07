package BOJ_2343_기타레슨;
import java.util.*;

public class Main {
    private static int solution(int[] nums,int n, int m){
        int a = 0;
        int right = Integer.MIN_VALUE;
        int sum =0;

        for(int i = 0 ; i < n; i++){
            right = Math.max(nums[i], right);
            sum += nums[i];
        }

        int left = 1;

        while(left <= right){
            int mid = (left + right) /2;
            int cnt = (sum + mid - 1) / mid;

            if(cnt >= m){
                a = mid;
                left = mid + 1;
            }
            else{
                right = mid -1;

            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(solution(nums, m, n));
    }
}
