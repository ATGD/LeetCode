package Problem_5737_所有数对按位与结果的异或和;

import java.util.ArrayList;

class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int res = 0;
        if ((arr1.length & 1) == 1) {

        } else {
            return 0;
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        int xorSum = new Solution().getXORSum(
                new int[]{12},
                new int[]{4}
        );
        System.out.println(xorSum);
    }
}