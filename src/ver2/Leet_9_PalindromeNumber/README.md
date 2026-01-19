# Leet_9_PalindromeNumber

## 문제 링크
https://leetcode.com/problems/palindrome-number/submissions/1560481412/?envType=problem-list-v2&envId=math

## 카테고리
`투 포인터`

## 접근 방식
투 포인터를 활용하여 팰린드롬인지를 확인하는 방식으로 해결했다.

## 코드
```java
package ver2.Leet_9_PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);

        boolean flag = true;

        int left = 0;
        int right = s.length() -1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                flag = false;
            }
            left++;
            right--;
        }
        return flag;
    }
}
```
