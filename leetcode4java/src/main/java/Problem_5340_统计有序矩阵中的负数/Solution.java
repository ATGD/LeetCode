package Problem_5340_统计有序矩阵中的负数;

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count += (grid[i].length - j);
                    break;
                }
            }
        }
        return count;
    }

//    [
//    [4,3,2,-1],
//    [3,2,1,-1],
//    [1,1,-1,-2],
//    [-1,-1,-2,-3]
//    ]
}
