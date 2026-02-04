package ver2;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= n; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[n];
    }
}

/*
# 카테고리
DP
# 접근 방식
DP easy 레벨의 문제이다
# 문제 링크
https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
