package Problem_0283_移动零;

class Solution {
    public void moveZeroes(int[] nums) {
        int tempIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[tempIndex] = nums[i];
                tempIndex++;
            }
        }
        for (int i = tempIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

class Test{
    public static void main(String[] args) {
        int[] nums = {0};
        new Solution().moveZeroes(nums);
        System.out.println(nums);
    }
}



