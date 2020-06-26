package Problem_0172_阶乘后的零;


class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for (long i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().trailingZeroes(100);
        System.out.println(i);
    }
}

