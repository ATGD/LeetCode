package Problem_0322_零钱兑换;

import java.util.Arrays;

class Solution {
    int[] consMinValues;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        consMinValues = new int[amount];
        return coinBackTrack(coins, amount);
    }

    private int coinBackTrack(int[] coins, int rem) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (consMinValues[rem - 1] != 0) return consMinValues[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int res = coinBackTrack(coins, rem - coins[i]);
            if (res < min && res >= 0)
                min = res + 1;
        }
        consMinValues[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return consMinValues[rem - 1];
    }
}
