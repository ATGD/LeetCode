package Problem_1791_找出星型图的中心节点;

class Solution {
    public int findCenter(int[][] edges) {
        int[] pointsCon = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            int point1 = edges[i][0];
            int point2 = edges[i][1];
            pointsCon[point1-1]++;
            pointsCon[point2-1]++;
            if (pointsCon[point1 - 1] > 1)
                return point1;

            if (pointsCon[point2-1] > 1)
                return point2;
        }
        return -1;
    }
}