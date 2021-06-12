package Comp_spring_2021_1采购方案;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int indexValue = target - nums[i];
            Integer index = map.get(indexValue);
            if (index != null) {
                if (index > i) {
                    count += index - i;
                }
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] <= target) {
                        count++;
                    } else
                        break;
                }
            }
        }
        return (int) (count % 1000000007);
    }
}