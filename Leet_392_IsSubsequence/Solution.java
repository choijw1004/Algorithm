package Leet_392_IsSubsequence;

import java.util.*;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLeng = s.length();
        int tLeng = t.length();

        int tBeginIndex = 0;

        for (int i = 0; i < sLeng; i++) { // s의 모든 문자를 탐색
            char sChar = s.charAt(i);
            boolean found = false;

            for (int j = tBeginIndex; j < tLeng; j++) { // t에서 현재 문자를 탐색
                char tChar = t.charAt(j);

                if (sChar == tChar) {
                    tBeginIndex = j + 1; // 다음 문자부터 탐색
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false; // s의 문자를 t에서 찾을 수 없으면 false 반환
            }
        }

        return true; // s의 모든 문자를 t에서 찾았으면 true 반환
    }
}
