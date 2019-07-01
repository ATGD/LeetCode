package Problem_0101_对称二叉树;

import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] r = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                r[0] = i;
                r[1] = map.get(target - nums[i]);
                return r;
            }
            map.put(nums[i], i);
        }

        return new int[]{0, 0};
    }
}

