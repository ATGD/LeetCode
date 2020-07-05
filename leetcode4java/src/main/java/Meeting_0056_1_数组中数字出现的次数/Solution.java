package Meeting_0056_1_数组中数字出现的次数;

class Solution {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) xor ^= nums[i];
        int mask = xor & (-xor);
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) result[0] ^= num;
            else result[1] ^= num;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().singleNumbers(new int[]{
                1, 1, 2, 2, 3, 4
        });
        System.out.println(ints);
    }
}