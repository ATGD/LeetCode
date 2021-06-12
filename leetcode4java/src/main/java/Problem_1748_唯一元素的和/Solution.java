package Problem_1748_唯一元素的和;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) count = 0;
            count++;
            map.put(num, count);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                count += entry.getKey();
            }
        }
        return count;
    }
}