package Prog_이중우선순위큐;

import java.util.*;

public class Solution {
    public int[] solution(String[] operations){
        int[] ans = new int[2];
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

        for(String s : operations){
            String[] st = s.split(" ");

            String operation = st[0];
            int num = Integer.parseInt(st[1]);
            //삽입
            if(operation.equals("I")){
                minH.offer(num);
                maxH.offer(num);
            }
            else{
                if(minH.isEmpty() || maxH.isEmpty()) continue;

                if(num == -1){
                    int minpoll = minH.poll();
                    maxH.remove(minpoll);
                }else{
                    int maxpoll = maxH.poll();
                    minH.remove(maxpoll);
                }

            }
        }

        if(maxH.size() > 0){
            ans[0] = maxH.poll();
            ans[1]= minH.poll();
        }
        else{
            ans[0] = 0;
            ans[1] = 0;
        }

        return ans;

    }
}
