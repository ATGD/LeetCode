package Problem_0463_岛屿的周长;

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (j - 1 < 0 || grid[i][j - 1] == 0) result++;
                    if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) result++;
                    if (i - 1 < 0 || grid[i - 1][j] == 0) result++;
                    if (i + 1 >= grid.length || grid[i + 1][j] == 0) result++;
                }
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().islandPerimeter(new int[][]{
                {0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}
        });
        System.out.println(i);
    }
}
