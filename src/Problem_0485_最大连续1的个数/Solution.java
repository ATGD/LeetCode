package Problem_0485_最大连续1的个数;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int preIndex = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1)
                preIndex = -1;
            else {
                if (preIndex == -1) {
                    preIndex = i;
                    max = Math.max(max, 1);
                } else
                    max = Math.max(max, i - preIndex + 1);
            }
        }
        return max;
    }
}

class Test {
    public static void main(String[] args) {
        int maxConsecutiveOnes = new Solution().findMaxConsecutiveOnes(new int[]{1, 2, 2, 2, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2});
        System.out.println(maxConsecutiveOnes);
    }
}