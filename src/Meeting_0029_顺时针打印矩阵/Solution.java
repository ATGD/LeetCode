package Meeting_0029_顺时针打印矩阵;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int[] resut = new int[(matrix.length) * (matrix[0].length)];
        int index = 0;
        int[] bound = new int[]{matrix[0].length, matrix.length, -1, 0};
        int state = 0;    //0向右，1向下，2向左，3向上
        int[] compare = new int[]{1, 1, -1, -1};
        int[][] axisAdd = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        while (index < resut.length) {
            if ((state & 1) == 1) {
                if (y + compare[state] == bound[state]) {
                    bound[state] = y;
                    state = (state + 1) % axisAdd.length;
                }
            } else {
                if (x + compare[state] == bound[state]) {
                    bound[state] = x;
                    state = (state + 1) % axisAdd.length;
                }
            }
            resut[index++] = matrix[y][x];
            x += axisAdd[state][1];
            y += axisAdd[state][0];
        }
        return resut;
    }
}

class Test {
    public static void main(String[] args) {
        int[] result = new Solution().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        System.out.println(result);
    }
}