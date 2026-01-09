package BOJ_2343_기타레슨;
import java.util.*;

public class Main {

    // mid 용량으로 녹화할 때 필요한 블루레이 개수를 구하는 함수
    private static boolean can(int[] nums, int m, int mid) {
        int count = 1; // 현재 사용한 블루레이 개수 (최소 1개는 사용)
        int sum = 0;   // 현재 블루레이에 담긴 강의 길이의 합

        for (int num : nums) {
            if (sum + num > mid) { // 현재 강의를 추가하면 mid를 초과한다면
                count++;         // 새로운 블루레이 사용
                sum = num;       // 새 블루레이에는 현재 강의를 담음
            } else {
                sum += num;      // 현재 블루레이에 계속 담음
            }
        }
        return count <= m; // 필요한 블루레이 개수가 m개 이하이면 true 반환
    }

    private static int solution(int[] nums, int m) {
        // 최소 용량은 강의들 중 가장 긴 강의, 최대 용량은 전체 강의 합
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        int ans = right; // 초기값은 최대 용량

        // 이분 탐색
        while (left <= right) {
            int mid = (left + right) / 2;

            if (can(nums, m, mid)) {
                // mid 용량으로 녹화 가능하면 더 작은 용량으로도 가능한지 탐색
                ans = mid;
                right = mid - 1;
            } else {
                // mid 용량으로 녹화 불가능하면, 용량을 늘려야 함
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(solution(nums, m));
    }
}
