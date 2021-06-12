package Problem_5777_使数组元素相等的减少操作次数;

import java.util.TreeMap;

class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>((t0, t1) -> t1 - t0);
        for (int num : nums)
            map.put(num, 1 + map.getOrDefault(num, 0));

        int size = map.size();
        int count = 0;
        int index = 0;

        for (Integer integer : map.values()) {
            count += ((size - index - 1) * integer);
            index++;
        }

        return count;
    }
}