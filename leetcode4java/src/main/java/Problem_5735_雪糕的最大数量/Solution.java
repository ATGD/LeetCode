package Problem_5735_雪糕的最大数量;

import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                count++;
                coins-=cost;
            }
        }
        return count;
    }
}