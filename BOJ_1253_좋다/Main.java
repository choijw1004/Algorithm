package BOJ_1253_좋다;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int cnt = 0;

        // 배열에 입력값 저장
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        // 각 인덱스를 후보로 하여 해당 수가 다른 두 수의 합으로 표현 가능한지 탐색
        for (int i = 0; i < N; i++) {
            int target = nums[i];
            int left = 0;
            int right = N - 1;

            boolean isGood = false;
            while (left < right) {
                // 후보 인덱스와 같은 경우 건너뛰기
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
                    // 후보 수가 다른 두 수의 합으로 표현된다면
                    isGood = true;
                    break;
                } else if (sum < target) {
                    left++;
                } else { // sum > target
                    right--;
                }
            }
            if (isGood) cnt++;
        }

        System.out.println(cnt);
    }
}
