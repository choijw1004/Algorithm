package Prog_야근지수;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                int work = pq.poll();
                if (work > 0) {
                    pq.offer(work - 1);
                }
            }
        }

        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}

