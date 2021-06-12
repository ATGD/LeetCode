package Problem_5709_最大升序子数组和;

class Solution {
    public int maxAscendingSum(int[] nums) {
        int lastNum = Integer.MIN_VALUE;
        int tmpCount = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num > lastNum) {
                tmpCount += num;
            } else {
                tmpCount = num;
            }
            maxCount = Math.max(maxCount, tmpCount);
            lastNum = num;
        }
        return maxCount;
    }
}