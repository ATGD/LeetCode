package Problem_0300_最长上升子序列;

class Solution {


    public int lengthOfLIS(int[] nums) {
        return recursionList(nums, 0, null);
    }

    private int recursionList(int[] nums, int index, Integer start) {
        if (index >= nums.length) return 0;
        if (start == null || start < nums[index]) {
            return Math.max(recursionList(nums, index + 1, start), 1 + recursionList(nums, index + 1, nums[index]));
        } else {
            return recursionList(nums, index + 1, start);
        }
    }
}

class Test {
    public static void main(String[] args) {
        int maxLength = new Solution().lengthOfLIS(new int[]{
                4, 10, 4, 3, 8, 9
        });
        System.out.println(maxLength);
    }
}