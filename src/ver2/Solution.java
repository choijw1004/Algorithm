package ver2;

class Solution {
    int[] piles;
    int h;

    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        this.h = h;
        long ans = 0;
        long max = -1;

        for(int p : piles){
            max = Math.max(p,max);
        }

        long start = 1;
        long end = max;

        while(start <= end){
            long mid = (start + end) / 2;

            if(canEat(mid)) {
                ans = mid;
                end = mid -1;
            }
            else start = mid + 1;
        }

        return (int)ans;
    }

    private boolean canEat(long time){
        long cnt = 0;

        for(int p : piles){
            cnt += (p + time -1)/ time;
        }

        return cnt <= h ? true : false;
    }
}

/*
# 카테고리
이분탐색
# 접근 방식
하나의 일차원 배열이 있고 그 배열의 모든 조건을 부합하는 최소의 정수 N을 구하는 문제이다.
이를 구하기 위해서 먼저 1 ~ max까지의 선형적인 수들의 최댓값 max를 정의하고 그 max 사이의 값을 이분탐색으로 찾아준다
```
while(start <= end){
    long mid = (start + end) / 2;

    if(canEat(mid)) {
        ans = mid;
        end = mid -1;
    }
    else start = mid + 1;
}
```
# 문제 링크
https://leetcode.com/problems/koko-eating-bananas/
 */