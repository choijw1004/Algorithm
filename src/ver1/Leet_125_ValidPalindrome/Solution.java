package Leet_125_ValidPalindrome;

import java.util.*;

public class Solution {

    public static boolean isPalindrome(String s) {
        // 1. 유효한 문자(알파벳, 숫자)만 남기고 소문자로 변환
        s = s.toLowerCase().replaceAll("[a-zA-Z0-9]", "");

        // 2. 양쪽 포인터 초기화
        int leftPoint = 0;
        int rightPoint = s.length() - 1;

        // 3. 투 포인터로 비교
        while (leftPoint <= rightPoint) {
            if (s.charAt(leftPoint) != s.charAt(rightPoint)) {
                return false;
            }
            leftPoint++;
            rightPoint--;
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";


//        System.out.println(s);
        System.out.println(isPalindrome(s));
    }
}
