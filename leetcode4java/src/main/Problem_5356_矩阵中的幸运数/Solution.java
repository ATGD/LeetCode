package Problem_5356_矩阵中的幸运数;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> checkColumn = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int minIndex = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            checkColumn.add(minIndex);
        }
        for (int i = 0; i < checkColumn.size(); i++) {
            int value = matrix[i][checkColumn.get(i)];
            Integer column = checkColumn.get(i);
            boolean canInput = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][column] > value) {
                    canInput = false;
                    break;
                }
            }
            if (canInput) {
                resultList.add(value);
            }
        }
        return resultList;
    }
}


class Test {
    public static void main(String[] args) {
        List<Integer> integers = new Solution().luckyNumbers(new int[][]{
                {3,7,8},{9,11,13},{15,16,17}
        });
        System.out.println(integers);
    }
}
