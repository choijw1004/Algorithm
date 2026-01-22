package ver2.Leet_1423_Maximum_Points_You_Can_Obtain_from_Cards;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = Integer.MIN_VALUE;
        int n = cardPoints.length;
        int start = n - k;
        int end = n - k;
        int maxEnd = n + k - 1;
        int size = k;
        int sum = 0;

        int[] arr = new int[n*2];

        for(int i = 0 ; i < n; i++){
            arr[i] = cardPoints[i];
            arr[i + n] = cardPoints[i];
        }

        while(end <= maxEnd){
            if(end - start + 1 < size){
                sum += arr[end];
                end++;
            }
            else{
                sum += arr[end];

                max = Math.max(sum, max);

                sum -= arr[start];

                start++;
                end++;
            }
        }

        return max;
    }
}

/*
# 카테고리
슬라이딩 윈도우
# 접근 방식
끝에서부터 카드를 집을 수 있는 고정된 슬라이딩 윈도우 문제이다.

따라서 배열을 2배로 늘려서 원형 큐의 모양으로 원본 배열을 변형하여 슬라이딩 윈도우를 적용하는 방식으로 해결했다.
# 문제 링크
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */