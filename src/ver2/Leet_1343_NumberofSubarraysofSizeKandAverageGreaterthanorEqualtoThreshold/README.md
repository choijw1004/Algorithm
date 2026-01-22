# Leet_1343_NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold

## 문제 링크
https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

## 카테고리
`슬라이딩 윈도우`

## 접근 방식
일반적인 고정된 슬라이딩 윈도우 문제이기에 비슷한 방법으로 풀었다.

## 코드
```java
package ver2.Leet_1343_NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold;

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0;
        int j = 0;
        int n = arr.length;
        int ans = 0;
        int sum = 0;

        while(j < n){
            if(j - i + 1 < k){
                sum += arr[j];
                j++;
            }
            else{
                sum += arr[j];

                if(sum / k >= threshold) ans++;

                sum -= arr[i];

                i++;
                j++;
            }
        }
        return ans;
    }
}
```
