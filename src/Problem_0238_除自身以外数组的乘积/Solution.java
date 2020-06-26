package Problem_0238_除自身以外数组的乘积;

class Solution {
    //1,2,3,4
    //1,2,6,24
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= R;
            R *= nums[i];
        }
        return answer;
    }
}


