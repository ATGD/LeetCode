package Problem_0338_比特位计数;

class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++)
            bits[i] = bits[i >> 1] + (i & 1);
        return bits;
//        00000  1,2
//        00001  2,3
//        00010  4,5
//        00011  6,7
//        00100  8,9
//        00101  10,11
//        00110  12,13
//        00111
//        01000
//        01001
//        01010
//        01011
//        01100
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().countBits(10);
        System.out.println(ints);
    }
}
