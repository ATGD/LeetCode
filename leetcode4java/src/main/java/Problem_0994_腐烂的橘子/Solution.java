package Problem_0994_腐烂的橘子;


import java.util.LinkedList;

class Solution {
    int[][] arround = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int count = 0;

    public int orangesRotting(int[][] grid) {
        LinkedList<Integer[]> list = new LinkedList<>();
        if (grid.length == 0 || grid[0].length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    list.addLast(new Integer[]{i, j});
                }
            }
        }
        while (list.size() > 0) {
            int size = list.size();
            boolean isAcc = false;
            for (int i = 0; i < size; i++) {
                Integer[] pos = list.pollFirst();
                for (int j = 0; j < arround.length; j++) {
                    int tmpY = pos[0] + arround[j][0];
                    int tmpX = pos[1] + arround[j][1];
                    if (tmpY >= 0
                            && tmpY < grid.length
                            && tmpX >= 0
                            && tmpX < grid[0].length
                            && grid[tmpY][tmpX] == 1) {
                        isAcc = true;
                        grid[tmpY][tmpX] = 2;
                        list.addLast(new Integer[]{tmpY, tmpX});
                    }
                }
            }
            if (isAcc) count++;
        }
        return findRottingCount(grid) == 0 ? count : -1;
    }


    public int findRottingCount(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        });
        System.out.println(i);
    }
}