# Leet_643_Maximum_Average_Subarray_I

## 문제 링크
https://leetcode.com/problems/maximum-average-subarray-i/

## 카테고리
`슬라이딩 윈도우`

## 접근 방식
이 문제 또한 고정된 슬라이딩 윈도우의 문제이다.
다만 음수의 값이 중간에 포함되어있어 ans의 초기 최소값을 Integer.MIN_VALUE로 설정하는 방식으로 풀어야한다.

## 코드
```java
package ver2.Leet_643_Maximum_Average_Subarray_I;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int size = k;
        int n = nums.length;
        int sum = 0;

        while(j < n){
            if(j - i + 1 < size){
                sum += nums[j];
                j++;
            }

            else{
                sum += nums[j];
                ans = Math.max(sum,ans);

                sum -= nums[i];

                i++;
                j++;
            }
        }
        ans /= k;

        return ans;

    }
}
```
