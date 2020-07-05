package Problem_0453_最小移动次数使数组元素相等;

import java.util.Arrays;

class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i] - nums[i - 1];
        }
        int count = 0;
        for (int i : dp) count += i;
        return count;
    }
}
