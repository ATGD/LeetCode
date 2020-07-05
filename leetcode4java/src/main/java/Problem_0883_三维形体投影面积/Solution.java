package Problem_0883_三维形体投影面积;

class Solution {
    public int projectionArea(int[][] grid) {
        int[] row = new int[grid.length];
        int[] column = new int[grid[0].length];
        int count = 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int itemValue = grid[i][j];
                row[i] = Math.max(row[i], itemValue);
                column[j] = Math.max(column[j], itemValue);
                count += (itemValue == 0 ? 0 : 1);
            }
        }
        for (int i : row)
            result += i;
        for (int i : column)
            result += i;
        result += count;
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().projectionArea(new int[][]{
                {2},
        });
        System.out.println(i);
    }
}
