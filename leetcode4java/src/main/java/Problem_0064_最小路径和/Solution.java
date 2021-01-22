package Problem_0064_最小路径和;

class Solution {
    private int row = 0;
    private int column = 0;

    private Integer[][] memo;
    private int[][] pos = new int[][]{
            {0, 1},
            {1, 0},
    };

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        row = grid.length - 1;
        column = grid[0].length - 1;
        memo = new Integer[grid.length][grid[0].length];
        return minPath(grid, 0, 0);
    }

    private int minPath(int[][] grid, int tmpRow, int tmpColumn) {
        if (tmpColumn > column || tmpRow > row) return Integer.MAX_VALUE;
        if (memo[tmpRow][tmpColumn] != null) return memo[tmpRow][tmpColumn];
        if (tmpRow == row && tmpColumn == column) {
            memo[tmpRow][tmpColumn] = grid[tmpRow][tmpColumn];
        } else {
            int min = Integer.MAX_VALUE;
            for (int[] po : pos) {
                min = Math.min(min, minPath(grid, tmpRow + po[0], tmpColumn + po[1]));
            }
            memo[tmpRow][tmpColumn] = min + grid[tmpRow][tmpColumn];
        }
        return memo[tmpRow][tmpColumn];
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        });
        System.out.println(result);
    }
}