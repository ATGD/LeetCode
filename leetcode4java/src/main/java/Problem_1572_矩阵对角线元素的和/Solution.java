package Problem_1572_矩阵对角线元素的和;

class Solution {
    public int diagonalSum(int[][] mat) {
        int num = 0;
        int length = mat.length;
        for (int i = 0; i < length; i++)
            num += mat[i][i];
        for (int i = 0; i < length; i++)
            num += mat[i][mat.length - i - 1];
        if ((mat.length & 1) == 1) {
            int mid = mat.length / 2;
            num -= mat[mid][mid];
        }
        return num;
    }
}