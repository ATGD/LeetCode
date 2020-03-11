package Problem_0812_最大三角形面积;

class Solution {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int P = 0; P < points.length - 2; P++) {
            for (int Q = P + 1; Q < points.length - 1; Q++) {
                for (int R = Q + 1; R < points.length; R++) {
                    max = Math.max(max, Math.abs(
                            points[P][0] * points[Q][1] +
                                    points[Q][0] * points[R][1] +
                                    points[R][0] * points[P][1] -
                                    points[P][1] * points[Q][0] -
                                    points[Q][1] * points[R][0] -
                                    points[R][1] * points[P][0]
                    ) / 2.0);
                }
            }
        }
        return max;
    }
}
