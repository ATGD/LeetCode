package Problem_5401_是否所有1都至少相隔k个元素;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - lastIndex <= k) return false;
                lastIndex = i;
            }
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().kLengthApart(new int[]{
                1, 0, 0, 1, 0, 0, 1
        }, 2);
        System.out.println(b);
    }
}