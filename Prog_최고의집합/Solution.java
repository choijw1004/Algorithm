package Prog_최고의집합;

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {

        int[] answer = new int[n];

        if(n > s){
            return new int[]{-1};
        }
        int b = s / n;
        int remainder = s  % n;

        Arrays.fill(answer, b);

        for(int i = 0 ; i < remainder; i++){
            answer[n -1 - i]++;
        }
        return answer;
    }
}