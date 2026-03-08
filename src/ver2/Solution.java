package ver2;

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n * 2];

        for(int i = 0 ; i < ans.length; i++){
            ans[i] = nums[i % n];
        }
        return ans;
    }
}

/*
# 카테고리
배열
# 접근 방식

# 문제 링크

 */