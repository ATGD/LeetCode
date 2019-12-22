package Problem_1252_奇数值单元格的数目;

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] rowArray = new boolean[n];
        boolean[] columnArray = new boolean[m];

        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int column = indices[i][1];
            rowArray[row] = !rowArray[row];
            columnArray[column] = !columnArray[column];
        }
        int rowCount = 0;
        int columnCount = 0;
        for (boolean b : rowArray) if (b) rowCount++;
        for (boolean b : columnArray) if (b) columnCount++;
        return rowCount * m + columnCount * n - 2 * columnCount * rowCount;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().oddCells(2, 2, new int[][]{
                {1, 1}, {0, 0}
        });
        System.out.println(i);
    }
}

