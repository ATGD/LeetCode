package Problem_0832_翻转图像;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
//        for (int i = 0; i < A.length; i++) {
//            Stack<Integer> stack = new Stack<>();
//            for (int j = 0; j < A[i].length; j++)
//                stack.add(1 - A[i][j]);
//            for (int j = 0; j < A[i].length; j++) {
//                A[i][j] = stack.pop();
//            }
//        }
//        return A;
        for (int i = 0; i < A.length; i++) {
            int temp;
            int L = A[i].length;
            for (int j = 0; j < (L + 1) / 2; j++) {
                temp = A[i][j]^1;
                A[i][j] = A[i][L - j - 1]^1;
                A[i][L - j - 1] = temp;
            }
        }
        return A;
    }
}

