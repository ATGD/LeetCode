package Problem_5426_重新规划路线;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            Set<Integer> integers = map.get(to);
            if (integers == null) {
                integers = new HashSet<>();
                map.put(to, integers);
            }
            integers.add(from);
        }
        Set<Integer> isConnects = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> goes = map.get(i);
            if (!goes.isEmpty()) {
                for (Integer go : goes) {
                    if (isConnects.contains(go)) continue;

                }
                count++;
            }
        }
        return 0;
    }

    class Station {
        int index = 0;
        Set<Integer> go = new HashSet<>();
    }
}