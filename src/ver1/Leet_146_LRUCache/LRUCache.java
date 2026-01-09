package Leet_146_LRUCache;

import java.util.*;

class LRUCache {

    public LinkedHashMap<Integer, Integer> linkedHashMap;
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //accessOrder = true -> 접근할떄 지속적 순서 보장.
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
