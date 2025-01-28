package Prog_기지국설치;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = w * 2 + 1;
        int curr = 1;

        for(int station : stations){
            int leftCover = station - w;
            int rightCover = station + w;

            if(curr < leftCover){

                answer += (leftCover - curr -1) / cover;
            }
            curr = rightCover + 1;
        }

        if(curr <= n){
            answer += (n - curr) / cover;
        }

        cover = answer;


        return answer;
    }
}
