package Meeting_0056_2_数组中数字出现的次数;

class Solution {
    public int singleNumber(int[] nums) {
        /*int one = 0;
        int two = 0;
        int three = 0;
        for (int num : nums) {
            one = (one ^ num) & (~two) & (~three);
            two = (two ^ num) & (~one) & (~three);
            three = (three ^ num) & (~one) & (~two);
        }
        return two;*/
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : nums) {
                if (((1 << i) & n) != 0) count++;
            }
            if ((count % 3) != 0) ans += (1 << i);
        }
        return ans;
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().singleNumber(new int[]{
                1,1,1,2,2,2,3,3,3,-4
        });
        System.out.println("乱序数字中只出现2次的数字为:" + result);
    }
}