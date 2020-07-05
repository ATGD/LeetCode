package Problem_1162_地图分析;

class Solution {

    int[][] pos = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maxDistance(int[][] grid) {
        int max = 0;
        int[][] oceanDis = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 0)
                    max = Math.max(max, calDis(grid, oceanDis, i, j));
        }
        return max;
    }

    private Integer calDis(int[][] grid, int[][] oceanDis, int i, int j) {
        if (!isInRange(grid, i, j)) return null;
        if (grid[i][j] == 1) return 0;
        if (oceanDis[i][j] != 0) return oceanDis[i][j];
        int dis = Integer.MAX_VALUE;
        boolean hasCal = false;
        for (int k = 0; k < pos.length; k++) {
            if (oceanDis[i + pos[k][0]][j + pos[k][1]] != -1) {
                if (oceanDis[i + pos[k][0]][j + pos[k][1]] == 0)
                    oceanDis[i + pos[k][0]][j + pos[k][1]] = -1;
                Integer disOnePos = calDis(grid, oceanDis, i + pos[k][0], j + pos[k][1]);
                if (disOnePos != null) {
                    dis = Math.min(dis, dis);
                    hasCal = true;
                }
            }
        }
        if (hasCal) oceanDis[i][j] = dis + 1;
        return oceanDis[i][j];
    }

    private boolean isInRange(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxDistance(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {0, 0, 0}
        });
        System.out.println(i);
    }
}