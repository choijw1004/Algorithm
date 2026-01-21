# Leet_1876_SubstringsofSizeThreewithDistinctCharacters

## 문제 링크
https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

## 카테고리
`슬라이딩 윈도우`

## 접근 방식
크기가 고정된 슬라이딩 윈도우의 전형적인 문제이다. 시작 포인터, 끝 포인터 두개를 통해서 String s의 문자들을 조작하여 문제를 해결했다.
문자의 빈도는 HashMap을 통해 구현했다.

## 코드
```java
package ver2.Leet_1876_SubstringsofSizeThreewithDistinctCharacters;

import java.util.*;

class Solution {
    public int countGoodSubstrings(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;

        int size = 3;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while(j < n){
            if(j - i + 1< size){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);
                j++;
            }
            else{
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);

                if(map.size() == size){
                    ans++;
                }

                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) -1);
                if(map.get(s.charAt(i)) <= 0) map.remove(s.charAt(i));
                i++;
                j++;
            }
        }
        return ans;
    }
}
```
