# Leet_378_Kth_Smallest_Element_in_a_Sorted_Matrix

## 문제 링크
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

## 카테고리
`자료구조` `우선순위 큐` 

## 접근 방식
2차원 배열들의 값들을 전부 minHeap에 넣고 k번쨰를 찾을 때까지 poll()해서 ans를 찾아낸다.




## 코드
```java
package ver2.Leet_378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        Queue<Integer> heap = new PriorityQueue<>();
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                heap.add(matrix[i][j]);
            }
        }
        int ans = 0;

        while(k -- > 0){
            ans = heap.poll();
        }

        return ans;
    }
}

/*
# 카테고리
자료구조, 우선순위 큐

# 접근 방식
2차원 배열들의 값들을 전부 minHeap에 넣고 k번쨰를 찾을 때까지 poll()해서 ans를 찾아낸다.

# 문제 링크
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

```
