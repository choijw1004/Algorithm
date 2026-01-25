package ver2.Leet_460_LRU_Cache;

import java.util.*;

class LRUCache {

    public LinkedHashMap<Integer, Integer> linkedHashMap;
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.linkedHashMap = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return linkedHashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);

        if (linkedHashMap.size() > capacity) {
            int leastUsedKey = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(leastUsedKey);
        }
    }
}

/*
# 카테고리
자료구조

# 접근 방식
linked hashmap을 사용하여 구현

# 문제 링크
https://leetcode.com/problems/lru-cache/description/
 */
