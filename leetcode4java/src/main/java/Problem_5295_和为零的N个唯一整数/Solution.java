package Problem_5295_和为零的N个唯一整数;

class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if ((n & 1) == 1) {
            int i = n / 2;
            int base = -i;
            for (int j = 0; j < result.length; j++) {
                result[j] = j + base;
            }
        } else {
            int i = n / 2;
            int base = i;
            for (int j = 0; j < result.length; j++) {
                if (j < result.length / 2) {
                    result[j] = -base + j;
                } else {
                    result[j] = base - (result.length - 1 - j);
                }
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().sumZero(12);
        System.out.println(ints);
    }
}
