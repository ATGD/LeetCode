package Problem_5307_将整数转换为两个无零整数的和;

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (("" + i).contains("0")) {
                continue;
            }
            if (("" + (n - i)).contains("0")) {
                continue;
            }
            return new int[]{i, n - i};
        }
        return new int[0];
    }
}

class Test{
    public static void main(String[] args) {
        int[] noZeroIntegers = new Solution().getNoZeroIntegers(1001);
        System.out.println(noZeroIntegers);
    }
}
