package Problem_5723_查找用户活跃分钟数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> muniteSet = map.get(log[0]);
            if (muniteSet == null) muniteSet = new HashSet<>();
            muniteSet.add(log[1]);
            map.put(log[0], muniteSet);
        }
        int[] result = new int[k];
        for (Map.Entry<Integer, Set<Integer>> next : map.entrySet()) {
            Set<Integer> muniteSet = next.getValue();
            if (muniteSet.size() > 0 && (muniteSet.size() - 1) < k) {
                result[muniteSet.size() - 1]++;
            }
        }
        return result;
    }
}