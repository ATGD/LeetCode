package Problem_1260_二维网格迁移;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int totalLength = grid.length * grid[0].length;
        k %= totalLength;
        for (int i = 0; i < k; i++) {
            int positionLimit = totalLength + k;
            int tempPosition = i;
            Integer tempValue = null;
            while (tempPosition < positionLimit) {
                int after = tempPosition + k;
                after %= totalLength;
                int forthValue = grid[after / grid[0].length][after % grid[0].length];
                grid[after / grid[0].length][after % grid[0].length] = grid[tempPosition / grid[0].length][tempPosition % grid[0].length];
                if (tempValue != null) {
                    grid[tempPosition / grid[0].length][tempPosition % grid[0].length] = tempValue;
                }
                tempValue = forthValue;
                tempPosition += k;
            }
        }
        List<List<Integer>> gridList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
            gridList.add(list);
        }
        return gridList;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<List<Integer>> lists = new Solution().shiftGrid(arrays, 1);
        System.out.println(lists);
    }
}

