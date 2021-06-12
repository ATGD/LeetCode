package Problem_5728_最少侧跳次数;

class Solution {

    private Integer[][] memo;
    private int[] totalObstacles;

    public int minSideJumps(int[] obstacles) {
        memo = new Integer[obstacles.length][3];
        totalObstacles = obstacles;
        return getTmpPMin(0, 1, new boolean[]{
                totalObstacles[0] != 1, false, totalObstacles[0] != 3
        });
    }

    private Integer getTmpPMin(int index, int row, boolean[] route) {
        if (memo[index][row] != null) return memo[index][row];
        if (index == totalObstacles.length - 1) {
            if (totalObstacles[index] == row + 1) return 1;
            else return 0;
        }
        Integer min = null;
        for (int i = 0; i < route.length; i++) {
            if (route[i]) {
                route[i] = false;
                Integer tmpOtherMin = getTmpPMin(index, i, route);
                if (tmpOtherMin != null) {
                    int otherValue = 1 + tmpOtherMin;
                    if (min == null) {
                        min = otherValue;
                    } else {
                        min = Math.min(min, otherValue);
                    }
                }
            }
        }
        if (min != null && totalObstacles[index + 1] != row + 1) {
            Integer nextValue = getTmpPMin(index + 1, row, new boolean[]{
                    totalObstacles[index + 1] != 1, totalObstacles[index + 1] != 2, totalObstacles[index + 1] != 3
            });
            if (nextValue != null) {
                min = Math.min(min, nextValue);
            }
        }
        if (min != null) {
            memo[index][row] = min;
            return memo[index][row];
        }
        return null;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().minSideJumps(new int[]{0, 1, 2, 3, 0});
        System.out.println(i);
    }
}