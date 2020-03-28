package Meeting_0047_礼物的最大价值;

class Solution {
    Integer[][] dp;
    int row;
    int column;

    public int maxValue(int[][] grid) {
        row = grid.length;
        column = grid[0].length;
        dp = new Integer[row][column];
        return getMax(grid, dp, 0, 0);
    }

    private int getMax(int[][] grid, Integer[][] dp, int y, int x) {
        if (y >= row || x >= column) return 0;
        return dp[y][x] != null
                ? dp[y][x]
                : (dp[y][x] =
                grid[y][x] + Math.max(getMax(grid, dp, y + 1, x), getMax(grid, dp, y, x + 1)));
    }
}