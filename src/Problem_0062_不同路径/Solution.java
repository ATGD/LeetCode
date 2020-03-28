package Problem_0062_不同路径;

class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return calNum(memo, m, n);
    }

    private int calNum(Integer[][] memo, int m, int n) {
        if (m == 1 || n == 1) return memo[m - 1][n - 1] = 1;
        if (memo[m - 1][n - 1] != null) return memo[m - 1][n - 1];
        else{
            int value  = calNum(memo, m - 1, n) + calNum(memo, m, n - 1);
            return memo[m-1][n-1] = value;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().uniquePaths(3, 3);
        System.out.println(i);
    }
}
