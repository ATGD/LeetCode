package Problem_5484_找出第N个二进制字符串中的第K位;

class Solution {
    public char findKthBit(int n, int k) {
        long K = k;
        boolean reverseFlag = false;
        int countN = n;
        long bitCount = 1;
        while (countN > 1) {
            bitCount = bitCount * 2 + 1;
            countN--;
        }
        while (K > 1) {
            if (K == bitCount / 2 + 1) return '1';
            if (K > bitCount / 2) {
                reverseFlag = !reverseFlag;
                K = bitCount - K;
            }
            bitCount = (bitCount - 1) / 2;
        }
        return reverseFlag ? '1' : '0';
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthBit(3, 1));
        System.out.println(new Solution().findKthBit(3, 2));
        System.out.println(new Solution().findKthBit(3, 3));
        System.out.println(new Solution().findKthBit(3, 4));
        System.out.println(new Solution().findKthBit(3, 5));
        System.out.println(new Solution().findKthBit(3, 6));
    }
}