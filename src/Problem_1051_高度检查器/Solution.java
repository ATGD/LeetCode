package Problem_1051_高度检查器;

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        Arrays.sort(clone);
        int differient = 0;
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] != heights[i])
                differient++;
        }
        return differient;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().heightChecker(new int[]{1, 1, 4, 2, 1, 3});
        System.out.println(i);
    }
}

