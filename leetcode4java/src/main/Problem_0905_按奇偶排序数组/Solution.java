package Problem_0905_按奇偶排序数组;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 1) B[end--] = A[i];
            else B[start++] = A[i];
        }
        return B;
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().sortArrayByParity(new int[]{3, 1, 2, 4});
        System.out.println(ints);
    }
}
