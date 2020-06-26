package Problem_0746_使用最小花费爬楼梯;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] stepMap = new Integer[cost.length];
        return getMinRouteStep(cost, -1, stepMap);
    }

    private int getMinRouteStep(int[] cost, int i, Integer[] stepMap) {
        if (i >= cost.length) return 0;
        int step1, step2;
        if (i + 1 < stepMap.length && stepMap[i + 1] != null) step1 = stepMap[i + 1];
        else {
            step1 = getMinRouteStep(cost, i + 1, stepMap);
            if (i + 1 < stepMap.length)
                stepMap[i + 1] = step1;
        }
        if (i + 2 < stepMap.length && stepMap[i + 2] != null) step2 = stepMap[i + 2];
        else {
            step2 = getMinRouteStep(cost, i + 2, stepMap);
            if (i + 2 < stepMap.length)
                stepMap[i + 2] = step2;
        }
        return (i >= 0 ? cost[i] : 0) + Math.min(step1, step2);
    }
}
//0,0
//1,0
//100,1
//101,2
//3,2

class Test {
    public static void main(String[] args) {
        int i = new Solution().minCostClimbingStairs(
                new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        );
        System.out.println(i);
    }
}


