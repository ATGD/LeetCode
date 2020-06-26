package Problem_0977_有序数组的平方;

class Solution {
    public int[] sortedSquares(int[] A) {
        int nagIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) nagIndex = i;
            A[i] = A[i] * A[i];
        }
        int posIndex = nagIndex + 1;
        int[] results = new int[A.length];
        int tempPostion = 0;
        while (tempPostion < A.length) {
            if (nagIndex >= 0 && posIndex < A.length) {
                if (A[nagIndex] <= A[posIndex]) {
                    results[tempPostion] = A[nagIndex];
                    nagIndex--;
                } else {
                    results[tempPostion] = A[posIndex];
                    posIndex++;
                }
            } else if (nagIndex >= 0) {
                results[tempPostion] = A[nagIndex];
                nagIndex--;
            } else {
                results[tempPostion] = A[posIndex];
                posIndex++;
            }
            tempPostion++;
        }
        return results;
    }
}


class Test {
    public static void main(String[] args) {

    }
}

