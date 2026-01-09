package BOJ_6236_용돈관리;
import java.util.*;

public class Main {
    private static boolean isOk(int[] nums, int K, int M) {
        int count = 0;
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (current < nums[i]) {
                current = K;
                count++;
            }
            current -= nums[i];

        }
        return count <= M;
    }

    private static int solution(int[] nums, int m){
        int ans = 0;
        int n = nums.length;
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        while(left <= right){
            int mid = (left + right) / 2;
            if(isOk(nums, mid, m)){
                ans = mid;
                right = mid -1;
            }
            else left  = mid + 1;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();;
        int[] nums = new int[n];

        for(int i = 0 ; i < n; i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(solution(nums,m));
    }
}
