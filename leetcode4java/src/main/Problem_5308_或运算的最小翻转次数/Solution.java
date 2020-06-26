package Problem_5308_或运算的最小翻转次数;

class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            int cRetain = c % 2;
            int aRetain = a % 2;
            int bRetain = b % 2;
            if (cRetain == 0) {
                count += (aRetain + bRetain);
            } else {
                if (aRetain + bRetain == 0) {
                    count++;
                }
            }
            c = c >>> 1;
            b = b >>> 1;
            a = a >>> 1;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().minFlips(2, 6, 5);
        System.out.println(i);
    }
}

