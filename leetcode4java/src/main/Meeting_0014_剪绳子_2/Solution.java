package Meeting_0014_剪绳子_2;

import java.math.BigInteger;

class Solution {
    private BigInteger[] memo;

    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        memo = new BigInteger[n];
        return recursionResult(n).mod(new BigInteger("1000000007")).intValue();
    }

    private BigInteger recursionResult(int n) {
//        if (n == 0) return new BigInteger("1");
//        if (memo[n - 1] != null) return memo[n - 1];
//        BigInteger max = new BigInteger("0");z
//        for (int i = 1; i <= n; i++) {
//            memo[i] = memo[i].max(memo[j].multiply(memo[i-j]));
//        }
        return memo[n - 1];
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().cuttingRope(120);
        System.out.println(i);
//        1000000007
//        546281429
    }
}