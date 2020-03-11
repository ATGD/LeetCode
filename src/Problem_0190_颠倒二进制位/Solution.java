package Problem_0190_颠倒二进制位;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int returnValue = 0;
        for (int i = 0; i < 32; i++) {
            int returnValue1 = (n % 2) << (31 - i);
            returnValue |= returnValue1;
            n = (n >>> 1);
            if (n == 0)
                break;
        }
        return  returnValue;
    }
}

class Test {
    public static void main(String[] args) {
//        int i = new Solution().reverseBits(0b11111111111111111111111111111101);
        System.out.println(0b11111111111111111111111111111101L);
//        System.out.println(i);
    }
}

