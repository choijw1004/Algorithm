package Leet_75_ContainerWithMostWater;

import java.util.*;

class Solution {

    public int calcuArea(int[] heights, int leftPoint, int rightPoint){

        int area = 0;
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
        int rightPoint = height.length -1;

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