package Problem_5425_切割后面积最大的蛋糕;

import java.util.PriorityQueue;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxW = Integer.MIN_VALUE;
        long maxH = Integer.MIN_VALUE;
        long lastW = 0;
        long lastH = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int verticalCut : verticalCuts) queue.offer(verticalCut);
        while (!queue.isEmpty()) {
            Integer cutIndex = queue.poll();
            maxW = Math.max(maxW, cutIndex - lastW);
            lastW = cutIndex;
        }
        maxW = Math.max(maxW, w - lastW);
        queue.clear();
        for (int horizontalCut : horizontalCuts) queue.offer(horizontalCut);
        while (!queue.isEmpty()) {
            Integer cutIndex = queue.poll();
            maxH = Math.max(maxH, cutIndex - lastH);
            lastH = cutIndex;
        }
        maxH = Math.max(maxH, h - lastH);
        return (int) (maxH * maxW % (1000000000 + 7));
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxArea(5, 4, new int[]{3}, new int[]{3});
        System.out.println(i);
    }
}