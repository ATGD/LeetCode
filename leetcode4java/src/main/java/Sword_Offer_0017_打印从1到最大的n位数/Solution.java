package Sword_Offer_0017_打印从1到最大的n位数;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] printNumbers(int n) {
        int end = 1;
        while (n > 0) {
            end *= 10;
            n--;
        }
        end--;
        int[] result = new int[end];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().printNumbers(2);
        System.out.println(ints);
    }
}