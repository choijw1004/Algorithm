package ver2.Leet_438_FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    HashMap<Character, Integer> target;

    public List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        int j = 0;
        int size = p.length();
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();

        target = new HashMap<>();

        for(int x = 0; x < size; x++){
            char c = p.charAt(x);

            target.put(c, target.getOrDefault(c, 0) + 1);
        }


        while(j < n){
            if(j - i + 1 < size){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            else{
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if(map.equals(target)) ans.add(i);

                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);

                if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));

                i++;
                j++;
            }
        }

        return ans;
    }
}

/*
# 카테고리
슬라이딩 윈도우

# 접근 방식
두 개의 빈도수를 관리하는 방식으로 문제를 해결할 수 있었다.
첫번째 target을 관리하는 target Map
두번째 윈도우를 진행하고있는 문자의 빈도수를 관리하는 map Map

HashMap의 메서드 .equals 를 사용하면 자동으로 키와 값을 비교해줘서 같다면 list에 시작 인덱스를 넣는 방식으로 해결했다.

# 문제 링크
https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */