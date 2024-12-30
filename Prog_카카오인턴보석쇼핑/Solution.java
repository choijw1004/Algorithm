package Prog_카카오인턴보석쇼핑;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(List.of(gems));
        int totalTypes = gemTypes.size();

        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;

        int[] answer = new int[2];

        Map<String, Integer> gemCount = new HashMap<>();

        while (end < gems.length) {
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
            end++;

            while (gemCount.size() == totalTypes) {
                // 현재 구간 길이
                if (end - start < length) {
                    length = end - start;
                    answer[0] = start + 1; // 1-based index
                    answer[1] = end; // 1-based index
                }

                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if (gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                start++;
            }
        }

        return answer;
    }
}
