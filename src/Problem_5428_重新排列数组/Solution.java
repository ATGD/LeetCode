package Problem_5428_重新排列数组;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        for (int i = 0; i < 2 * n; i++) {
            if ((i & 1) != 1) {
                result[i] = nums[i / 2];
            } else {
                result[i] = nums[i / 2 + n];
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] result = new Solution().shuffle(new int[]{
                0
        }, 0);
        System.out.println(result);
    }
}