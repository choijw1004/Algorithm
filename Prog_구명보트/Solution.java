package Prog_구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while(left <= right){
            int tmp = people[left] + people[right];

            if(tmp <= limit){
                answer++;
                left++;
                right--;
            }

            if(tmp > limit){
                answer++;
                right--;
            }
        }
        return answer;
    }
}