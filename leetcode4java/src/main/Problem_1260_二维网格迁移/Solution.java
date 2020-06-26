package Problem_1260_二维网格迁移;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int column = grid[0].length;
        int length = row * column;
        int startIndex = length - k % length;
        int[] originArray = new int[length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                originArray[i * column + j] = grid[i][j];
        }
        List<List<Integer>> result = new ArrayList<>();
        int shuldAddPosition = startIndex;
        for (int i = 0; i < row; i++) {
            List<Integer> itemList = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                itemList.add(originArray[shuldAddPosition % length]);
                shuldAddPosition++;
            }
            result.add(itemList);
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<List<Integer>> lists = new Solution().shiftGrid(arrays, 13);
        System.out.println(lists);
    }
}

