package Leet_167_TwoSum2;

import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] solArray = new int[2];

        int leftPoint = 0;
        int rightPoint = numbers.length -1;

        while(leftPoint <= rightPoint){
            int twoSum = numbers[leftPoint] + numbers[rightPoint];

            if(twoSum > target){
                rightPoint--;
            }

            if(twoSum < target){
                leftPoint++;
            }

            if(twoSum == target){
                solArray[0] = leftPoint + 1;
                solArray[1] = rightPoint + 1;

                break;
            }
        }

        return solArray;
    }
}