package Problem_1207_独一无二的出现次数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> appearSet = new HashSet<>();
        for (int i : arr) {
            if (countMap.containsKey(i)) countMap.put(i, countMap.get(i) + 1);
            else countMap.put(i, 1);
        }
        Iterator<Integer> iterator = countMap.values().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (appearSet.contains(next)) return false;
            appearSet.add(next);
        }
        return true;
    }
}

