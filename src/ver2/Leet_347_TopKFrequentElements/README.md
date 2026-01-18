# Leet_347_TopKFrequentElements

## 문제 링크
https://leetcode.com/problems/top-k-frequent-elements/

## 카테고리
`정렬`

## 접근 방식
빈도수에 관련된 정렬 문제이다. 단순 배열의 정렬이 아니라 숫자들의 빈도수를 확인하고 그에 따른 정렬을 해야한다.
따라서 빈도수를 체크하기위한 hashmap을, 빈도수 맵을 entryset으로 변환하여 정렬한 뒤 그 이후 top k 를 뽑아내는 방식으로 풀어냇다.

## 코드
```java
package ver2.Leet_347_TopKFrequentElements;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a,b) -> b.getValue() - a.getValue());

        int[] ans = new int[k];

        for(int i = 0; i < k; i++){
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }
}
```
