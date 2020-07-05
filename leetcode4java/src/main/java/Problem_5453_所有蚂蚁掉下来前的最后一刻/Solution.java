package Problem_5453_所有蚂蚁掉下来前的最后一刻;

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;
        for (int i = 0; i < left.length; i++) {
            maxLeft = Math.max(maxLeft, left[i]);
        }
        for (int i = 0; i < right.length; i++) {
            minRight = Math.min(minRight, right[i]);
        }
        int lastMoment = Integer.MIN_VALUE;
        if (maxLeft != Integer.MAX_VALUE) {
            lastMoment = Math.max(lastMoment, maxLeft);
        }
        if (minRight != Integer.MAX_VALUE) {
            lastMoment = Math.max(lastMoment, n - minRight);
        }
        return lastMoment;
    }
}