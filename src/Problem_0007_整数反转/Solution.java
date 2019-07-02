package Problem_0007_整数反转;

import java.util.HashMap;

class Solution {
    public int reverse(int x) {
        long sum = 0L;//累加起来的反转数
        int temp = Math.abs(x);//计算当前位数
        while ((x / 10) != 0) {

            temp = x % 10;
            sum = sum * 10 + temp;
            x = x / 10;
        }
        sum = sum * 10 + x % 10;
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }
}

