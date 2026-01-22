package ver2.Leet_2090_KRadiusSubarrayAverages;

import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = 0;
        long size = 2 * k + 1;
        long sum = 0;
        Arrays.fill(ans,-1);

        if(k == 0) return nums;


        while(j < n){
            if(j - i + 1 < size){
                sum += nums[j];
                j++;
            }

            else{
                sum += nums[j];
                ans[(i + j) / 2] = (int)(sum / size);

                sum -= nums[i];

                i++;
                j++;
            }

        }

        return ans;

    }
}

/*
# 카테고리
슬라이딩 윈도우
# 접근 방식
고정된 슬라이딩 윈도우 문제에서 변형이 있는 문제이다.

슬라이딩 윈도우 문제에서 i,j 두 개의 포인터를 드는 방식으로 문제를 푸는데 그 중 중간의 인덱스의 처리에 관련된 문제여서 기존 방식과 함꼐 ans 배열에 i + j / 2로 인덱스 처리를 하는 방식으로 문제를 해결햇다.

# 문제 링크
https://leetcode.com/problems/k-radius-subarray-averages/
 */