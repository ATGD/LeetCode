package Problem_0322_零钱兑换;

import java.util.Arrays;

class Solution {
    Integer[] consMinValues;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        consMinValues = new Integer[amount];
        return coinBackTrack(coins, amount);
    }

    private int coinBackTrack(int[] coins, int rem) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (consMinValues[rem - 1] != null) return consMinValues[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int res = coinBackTrack(coins, rem - coins[i]);
            if (res + 1 < min && res >= 0)
                min = res + 1;
        }
        consMinValues[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return consMinValues[rem - 1];
    }
}

class Test{
    public static void main(String[] args) {
        int i = new Solution().coinChange(
                new int[]{1, 2, 5},
                1572
        );
        System.out.println(i);
    }
}
