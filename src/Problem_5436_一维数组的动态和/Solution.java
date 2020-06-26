package Problem_5436_一维数组的动态和;

class Solution {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int tmpSum = 0;
        for (int i = 0; i < result.length; i++) {
            tmpSum += result[i];
            result[i] = tmpSum;
        }
        return result;
    }
}