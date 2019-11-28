package Problem_0633_平方数之和;

class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().judgeSquareSum(1000);
        System.out.println(b);
    }
}

