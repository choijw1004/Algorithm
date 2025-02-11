package BOJ_2473_세용액;
import java.util.*;

public class Main {
    public static long[] solution(long[] nums){
        long[] ans = new long[3];

        Arrays.sort(nums);
        int N = nums.length;
        long minDiff = Long.MAX_VALUE;

        for(int i = 0 ; i < N-2; i++){
            int left = i + 1;
            int right = N - 1;

            while(left < right){
                long sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(sum) < Math.abs(minDiff)){
                    minDiff = sum;
                    ans[0] = nums[i];
                    ans[1] = nums[left];
                    ans[2] = nums[right];
                }

                if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] nums = new long[N];

        for(int i = 0; i < N; i++){
            nums[i] = sc.nextLong();
        }
        long[] ans = solution(nums);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);

    }
}
