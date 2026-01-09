package BOJ_1253_좋다;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            int target = nums[i];
            int left = 0;
            int right = N - 1;

            boolean isGood = false;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = nums[left] + nums[right];
                if (sum == target) {
                    isGood = true;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            if (isGood) cnt++;
        }

        System.out.println(cnt);
    }
}
