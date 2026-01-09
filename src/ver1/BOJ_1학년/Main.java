package BOJ_1학년;

import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int target;
    static long count = 0;

    static void dfs(int index, int sum) {
        if (sum < 0 || sum > 20) {
            return; // 범위를 벗어나면 탐색 중단
        }

        if (index == N - 1) { // 마지막 숫자 직전
            if (sum == target) {
                count++; // 목표 값과 같으면 경우의 수 증가
            }
            return;
        }

        dfs(index + 1, sum + nums[index]); // 현재 숫자를 더함
        dfs(index + 1, sum - nums[index]); // 현재 숫자를 뺌
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        target = nums[N - 1]; // 마지막 숫자가 목표 값
        dfs(1, nums[0]); // 첫 번째 숫자는 초기값으로 사용
        System.out.println(count);
    }
}
