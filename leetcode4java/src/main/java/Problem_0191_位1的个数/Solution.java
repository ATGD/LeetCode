package Problem_0191_位1的个数;


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int zeroCount = 0;
        while (n != 0) {
            if ((n & 0x1) == 0x1) {
                zeroCount++;
            }
            n = n >>> 1;
        }
        return zeroCount;
    }

}

class Test {
    public static void main(String[] args) {
        int i = new Solution().hammingWeight(-2147483648);
        System.out.println(i);
    }
}

