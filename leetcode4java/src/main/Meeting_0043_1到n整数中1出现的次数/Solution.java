package Meeting_0043_1到n整数中1出现的次数;

class Solution {
    public int countDigitOne(int n) {
        return dfs(n);
    }

    //1,10,11,12,
    private int dfs(int n) {
        if (n <= 0) return 0;
        String numStr = String.valueOf(n);
        int high = numStr.charAt(0) - '0';
        int pow = (int) Math.pow(10, numStr.length() - 1);
        int last = n - high * pow;

        if (high == 1) {
//            1234
//            dfs(pow - 1)      0到999的个数
//            dfs(last)         234中的个数,配合高位的1
//            last +1           单纯千位出现的次数
            return dfs(pow - 1) + dfs(last) + last + 1;
        } else {
//            8234
//            high        千位为1的时候，千位1出现的次数
//            high * dfs(pow -1)    0到999出现的个数
//            dfs(last)             234配合当千位是1时的个数
            return pow + high * dfs(pow - 1) + dfs(last);
        }
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().countDigitOne(12);
        System.out.println(i);
    }
}