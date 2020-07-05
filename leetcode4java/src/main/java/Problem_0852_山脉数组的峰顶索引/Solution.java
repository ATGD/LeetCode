package Problem_0852_山脉数组的峰顶索引;

class Solution {
    public int peakIndexMountainArray(int[] A) {
        int i=0;
        for (;i < A.length - 1;i++)
            if (A[i] > A[i+1]) break;
        return i;
    }
}