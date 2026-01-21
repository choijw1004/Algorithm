# Leet_1297_MaximumNumberofOccurrencesofaSubstring

## 문제 링크
https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

## 카테고리
`슬라이딩 윈도우`

## 접근 방식
고정된 슬라이딩 윈도우 문제이다.

문자열 자체의 빈도수를 계산하기 위해 HashMap<String, Integer>을 사용했다.
문자열의 각각 개별 문자의 빈도수를 사용하기 위해 HashSet을 사용했다.
또한 map의 빈도수를 list로 변환하여 역정렬하여 0 번째 인덱스에서 가장 많은 빈도수를 가지고 있는 문자열의 빈도를 찾아냈다.

`List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());`

## 코드
```java
package ver2.Leet_1297_MaximumNumberofOccurrencesofaSubstring;

import java.util.*;

class Solution {
    int ml;

    private boolean isValid(String s){
        HashSet<Character> set = new HashSet<>();

        for(int i = 0 ; i < s.length(); i++){
            set.add(s.charAt(i));
        }

        return set.size() <= ml ? true : false;
    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int i = 0, j = 0;
        int size = minSize;
        int n = s.length();
        this.ml = maxLetters;

        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        while(j < n){
            if(j - i + 1 < size){
                sb.append(s.charAt(j));
                j++;
            }

            else{
                sb.append(s.charAt(j));

                if(isValid(sb.toString())){
                    map.put(sb.toString(), map.getOrDefault(sb.toString(),0) + 1);
                }
                sb.deleteCharAt(0);
                i++;
                j++;
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());


        return list.size() == 0 ? 0 : list.get(0).getValue();
    }
}
```
