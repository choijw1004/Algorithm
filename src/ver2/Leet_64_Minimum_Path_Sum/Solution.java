package ver2.Leet_64_Minimum_Path_Sum;

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];

        int sum = grid[0][0];
        int sum1 = grid[0][0];

        for(int j = 0; j < m; j++){
            for(int i = 0 ; i < n; i++){
                if(i == 0 && j == 0) continue;

                if(i == 0){
                    sum += grid[i][j];
                    dp[i][j] = sum;
                }

                if(j == 0){
                    sum1 += grid[i][j];
                    dp[i][j] = sum1;
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[n-1][m-1];
    }
}

/*
# 카테고리
DP

# 접근 방식
2차원 배열 dp 문제로 해결하였다.

# 문제 링크
https://leetcode.com/problems/minimum-path-sum/
 */