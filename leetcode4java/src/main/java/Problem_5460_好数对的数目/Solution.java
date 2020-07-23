package Problem_5460_好数对的数目;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); //key:nums value   value:count
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) count = 0;
            count++;
            map.put(nums[i], count);
        }
        int totalCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count;
            if ((count = entry.getValue()) <= 1) continue;
            int sum = 1;
            for (int i = 0; i < 2; i++) sum *= (count - i);
            sum /= 2;
            totalCount += sum;
        }
        return totalCount;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numIdenticalPairs(
                new int[]{1,2,3,1,1,3}
        );
        System.out.println(i);
    }
}