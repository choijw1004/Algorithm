package BOJ_10986_수들의합;
import java.util.*;

public class Main {
    private static int solution(int[] nums, int m){
        int ans = 0;
        int n = nums.length;
        int[] pSum = new int[n];
        pSum[0] = nums[0];

        for(int i = 1; i < n; i++){
            pSum[i] = pSum[i-1] + nums[i];
        }


        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = sc.nextInt();

        System.out.println(solution(nums, m));
    }
}
