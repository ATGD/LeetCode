package Problem_0746_使用最小花费爬楼梯;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();
        return getMinRouteStep(cost, 0, map);
    }

    private int getMinRouteStep(int[] cost, int i, Map<Integer, Integer> stepMap) {
        if (i >= cost.length) return 0;
        return Math.min(
                cost[i] + getMinRouteStep(cost, i + 1, stepMap),
                ((i + 1 >= cost.length) ? 0 : cost[i + 1])
                        + getMinRouteStep(cost, i + 2, stepMap)
        );
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().minCostClimbingStairs(
                new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        );
        System.out.println(i);
    }
}


