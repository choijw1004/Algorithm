# Leet_54_SpiralMatrix

## 문제 링크
https://leetcode.com/problems/spiral-matrix/?envType=problem-list-v2&envId=array

## 카테고리
`2차원 배열`

## 접근 방식
방문을 처리하기 위한 visited 2차원 배열을 설정하여 방향전환을 할 수 있게 구현하였다.

## 코드
```java
package ver2.Leet_54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    public List<Integer> spiralOrder(int[][] matrix) {
        int max = matrix[0].length * matrix.length;
        int cx = 0;
        int cy = 0;
        int dir = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];


        List<Integer> ans = new ArrayList<>();

        while(max -- > 0){
            ans.add(matrix[cx][cy]);

            visited[cx][cy] = true;

            if(cx + dx[dir] < 0
                    || cx + dx[dir] >= n
                    || cy + dy[dir] < 0
                    || cy + dy[dir] >= m||
                    visited[cx + dx[dir]][cy + dy[dir]]){
                dir++;

                dir = dir % 4;
            }

            cx += dx[dir];
            cy += dy[dir];
        }
        return ans;
    }
}
```
