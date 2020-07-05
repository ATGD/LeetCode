package Problem_1030_距离顺序排列矩阵单元格;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] distances = new int[R * C][2];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                distances[r * C + c][0] = r - r0;
                distances[r * C + c][1] = c - c0;
            }
        }
        Arrays.sort(distances, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0]) + Math.abs(o1[1]) - Math.abs(o2[0]) - Math.abs(o2[1]);
            }
        });
        for (int i = 0; i < distances.length; i++) {
            distances[i][0] = distances[i][0] + r0;
            distances[i][1] = distances[i][1] + c0;
        }
        return distances;
    }
}
