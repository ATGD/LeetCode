package Meeting_0014_剪绳子;

class Solution {
    private Integer[] memo;

    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        memo = new Integer[n];
        return recursionResult(n);
    }

    private int recursionResult(int n) {
        if (n == 0) return 1;
        if (memo[n-1]!=null) return memo[n - 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, i * recursionResult(n - i));
        }
        memo[n-1] = max;
        return max;
    }
}

class Test{
    public static void main(String[] args) {
        int i = new Solution().cuttingRope(10);
        System.out.println(i);
    }
}