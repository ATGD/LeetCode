package Problem_0908_最小差值1;

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return Math.max(0, max - min - 2 * K);
    }
}
