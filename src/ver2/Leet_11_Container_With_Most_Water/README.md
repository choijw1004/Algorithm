# Leet_11_Container_With_Most_Water

## 문제 링크
https://leetcode.com/problems/container-with-most-water/

## 카테고리


## 접근 방식
투 포인터로 해결한 문제이다.

## 코드
```java
package ver2.Leet_11_Container_With_Most_Water;

class Solution {
    public int calcuArea(int[] heights, int leftPoint, int rightPoint){

        int area = -1;
        int width, height = 0;

        width = rightPoint - leftPoint;

        if(heights[leftPoint] >= heights[rightPoint]){
            height = heights[rightPoint];
        }
        else{
            height = heights[leftPoint];
        }

        area = width * height;

        return area;
    }

    public int maxArea(int[] height) {
        int maxArea = -1;

        int leftPoint = 0;
        int rightPoint = height.length - 1;

        while(leftPoint <= rightPoint){

            int tmpArea = calcuArea(height, leftPoint, rightPoint);

            if(tmpArea >= maxArea){
                maxArea = tmpArea;
            }

            if(height[leftPoint] < height[rightPoint]){
                leftPoint++;
            }
            else{
                rightPoint--;
            }
        }
        return maxArea;
    }
}
```
