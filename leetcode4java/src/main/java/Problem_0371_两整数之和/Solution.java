package Problem_0371_两整数之和;

class Solution {
    public int getSum(int a, int b) {
        //0111--->a
        //1001--->b
        //1110--->a^b temp
        //0001--->a&b
        //0010--->a&b<<1

        //1110--->a
        //0010--->b
        //1100--->a^b
        //0010--->a&b
        //0100--->a&b<<1

        //1100--->a
        //0100--->b
        //1000--->a^b
        //0100--->a&b
        //1000--->a&b<<1

        //1000--->a
        //1000--->b
        //0000--->a^b
        //1000--->a&b
        //10000--->a&b<<1

        //0000--->a
        //10000--->b
        //10000--->a^b

        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int temp = a ^ b;
            a = a ^ b;
            b = temp << 1;
        }
        return a;
    }
}

