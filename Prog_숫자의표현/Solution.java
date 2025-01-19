package Prog_숫자의표현;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1 ; i <= n; i++){
            int tmp = i;
            int target = 0;

            while(true){
                if(target == n){
                    answer++;
                    break;
                }
                if(target > n){
                    break;
                }
                target += tmp;
                tmp++;
            }
        }
        return answer;
    }
}