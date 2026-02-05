# BOJ_1806_부분합

## 문제 링크
https://www.acmicpc.net/problem/1806

## 카테고리
`슬라이딩 윈도우` `투 포인터` 


## 코드
```java
package ver2.BOJ_1806_부분합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(end < n){
            sum += nums[end];

            while(sum >= k){
                sum -= nums[start];
                start++;
            }
            min = Math.min(min, end - start + 1);
            end++;

        }

        if(min == Integer.MAX_VALUE) min = 0;

        System.out.println(min);
    }
}

/*
# 카테고리
슬라이딩 윈도우, 투 포인터

# 접근 방식
포인터 두 개를 둔 후 슬라이딩 윈도우를 진행하는 방식으로 해결했다.
# 문제 링크
https://www.acmicpc.net/problem/1806
 */

```
