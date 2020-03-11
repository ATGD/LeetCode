package Problem_0189_旋转数组;


class Solution {
        public void rotate(int[] nums, int k) {
        for (int i = 0; i < k % nums.length; i++) {
            turnOne(nums);
        }
    }

    private void turnOne(int[] nums) {
        int lastNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (i != 0) {
                nums[i] = lastNum;
            }
            if (i == nums.length - 1) {
                nums[0] = temp;
            }
            lastNum = temp;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        new Solution().rotate(nums, 2);
        System.out.println(nums);
    }
}

