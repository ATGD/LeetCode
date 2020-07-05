package Problem_0706_设计哈希映射;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    int barrelCount = 350;
    List<Entry<Integer, Integer>>[] entryBarrels = new LinkedList[barrelCount];

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        List<Entry<Integer, Integer>> entry = entryBarrels[hash(key)];
        if (entry == null) {
            entry = new LinkedList<>();
            entryBarrels[hash(key)] = entry;
        }
        for (Entry<Integer, Integer> itemEntry : entry) {
            if (itemEntry.key == key) {
                itemEntry.value = value;
                return;
            }
        }
        entry.add(new Entry<>(key, value));
    }


    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        List<Entry<Integer, Integer>> entry = entryBarrels[hash(key)];
        if (entry == null) {
            return -1;
        }
        for (Entry<Integer, Integer> itemEntry : entry) {
            if (itemEntry.key == key) {
                return itemEntry.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        List<Entry<Integer, Integer>> entrys = entryBarrels[hash(key)];
        if (entrys == null) {
            return;
        }
        Iterator<Entry<Integer, Integer>> iterator = entrys.iterator();
        while (iterator.hasNext()) {
            Entry<Integer, Integer> entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    public int hash(int key) {
        return key % barrelCount;
    }

    class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

class Test {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.get(1);
        myHashMap.get(3);
        myHashMap.put(2, 1);
        myHashMap.get(2);
        myHashMap.remove(2);
        myHashMap.get(2);
        System.out.println("初音ミク");
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


