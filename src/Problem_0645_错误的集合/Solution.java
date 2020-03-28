package Problem_0645_错误的集合;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] memo = new int[nums.length];
        int repeat = 0;
        int miss = 0;
        for (int i = 0; i < nums.length; i++) memo[nums[i] - 1]++;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == 0) miss = i + 1;
            if (memo[i] == 2) repeat = i + 1;
        }
        return new int[]{repeat, miss};
    }
}
