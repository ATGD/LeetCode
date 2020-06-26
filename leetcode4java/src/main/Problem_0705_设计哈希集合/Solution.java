package Problem_0705_设计哈希集合;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {

    int barrelCount = 350;
    List<Integer>[] entryBarrels = new List[barrelCount];

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {

    }

    public void add(int key) {
        if (contains(key)) return;
        List<Integer> entryBarrel = entryBarrels[hash(key)];
        if (entryBarrel == null) entryBarrels[hash(key)] = entryBarrel = new LinkedList<>();
        entryBarrel.add(key);
    }

    public void remove(int key) {
        List<Integer> entryBarrel = entryBarrels[hash(key)];
        if (entryBarrel == null) return;
        Iterator<Integer> iterator = entryBarrel.iterator();
        while (iterator.hasNext()) {
            Integer itemKey = iterator.next();
            if (itemKey == key) {
                iterator.remove();
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        List<Integer> entryBarrel = entryBarrels[hash(key)];
        if (entryBarrel == null) return false;
        for (Integer itemKey : entryBarrel) if (itemKey == key) return true;
        return false;
    }

    public int hash(int key) {
        return key % barrelCount;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class Test {
    public static void main(String[] args) {
//        MyHashSet myHashMap = new MyHashSet();
//        myHashMap.put(1, 1);
//        myHashMap.put(2, 2);
//        myHashMap.get(1);
//        myHashMap.get(3);
//        myHashMap.put(2, 1);
//        myHashMap.get(2);
//        myHashMap.remove(2);
//        myHashMap.get(2);
//        System.out.println("初音ミク");
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


