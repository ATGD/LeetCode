package Problem_5726_数组元素积的符号;

class Solution {
    public int arraySign(int[] nums) {
        int a = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] < 0) {
                a *= (-1);
            }
        }
        return a;
    }
}