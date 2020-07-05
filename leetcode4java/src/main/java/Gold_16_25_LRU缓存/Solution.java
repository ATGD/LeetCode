package Gold_16_25_LRU缓存;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(this.capacity, 0.75f, true);
    }

    public int get(int key) {
        Integer integer = map.get(key);
        return integer == null ? -1 : integer;
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
    }
}

class Test {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 2);
        lruCache.put(2, 3);
        lruCache.put(3, 4);
        System.out.println(lruCache);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */