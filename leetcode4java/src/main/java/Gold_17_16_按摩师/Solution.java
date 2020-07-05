package Gold_17_16_按摩师;

class Solution {
    private Integer[] memo;

    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        memo = new Integer[nums.length];
        recursionMassage(nums, 0);
        return memo[0];
    }

    private int recursionMassage(int[] nums, int index) {
        if (index >= nums.length) return 0;
        if (memo[index] != null) return memo[index];
        return memo[index] = Math.max(nums[index] + recursionMassage(nums, index + 2),
                recursionMassage(nums, index + 1));
    }
}

class Test {
    public static void main(String[] args) {
        int massage = new Solution().massage(new int[]{
                1, 2, 3, 1
        });
        System.out.println(massage);
    }
}