package BOJ_2467_용액;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];

        for(int i = 0 ; i < N; i++){
            nums[i] = sc.nextInt();
        }

        int left = 0;
        int right = N - 1;

        int[] ans = new int[2];
        int diff = Integer.MAX_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (Math.abs(sum) < diff) {
                diff = Math.abs(sum);
                ans[0] = nums[left];
                ans[1] = nums[right];
            }

            if (sum == 0) {
                break;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
