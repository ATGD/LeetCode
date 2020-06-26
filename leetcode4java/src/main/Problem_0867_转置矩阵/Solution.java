package Problem_0867_转置矩阵;

class Solution {
    public int[][] transpose(int[][] A) {
        if (A.length < 1) return A;
        int[][] B = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] transpose = new Solution().transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        });
        System.out.println(transpose);
    }
}