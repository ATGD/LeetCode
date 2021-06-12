package Problem_5776_判断矩阵经轮转后是否一致;

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        return isSame(mat, target)
                || isSame(rotate90(mat), target)
                || isSame(rotate90(mat), target)
                || isSame(rotate90(mat), target);
    }

    /**
     *
     * @param mat
     * @param target
     * @return 是否是相等的矩阵
     */
    public boolean isSame(int[][] mat, int[][] target) {
        int h = mat.length;
        int w = mat[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

    /**
     * 顺时针旋转90度
     * @param mat
     * @return 矩阵本身
     */
    public int[][] rotate90(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;
        for (int i = 0; i < h / 2; i++) {
            for (int j = 0; j < w; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[h - i - 1][j];
                mat[h - i - 1][j] = tmp;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
        return mat;
    }
}