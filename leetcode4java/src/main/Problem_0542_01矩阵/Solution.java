package Problem_0542_01矩阵;


import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Solution {
    /*public int[][] updateMatrix(int[][] matrix) {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        Timer
        executorService.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                calcDistance(matrix, i, j, 0);
            }
        }
    }

    private void calcDistance(int[][] matrix, int i, int j, int r) {
        int left = j - r;
        int top = i - r;
        int right = j + r;
        int bottom = i + r;
        if (top >= 0) {
            for (int k = left; k <= right; k++) {
                if (isInRange())
            }
        }
    }*/

    private boolean isInRange(int length, int left) {
        return left >= 0 && left < length;
    }

}
