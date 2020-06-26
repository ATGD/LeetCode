package Problem_0836_矩形重叠;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long x0 = rec1[0];
        long y0 = rec1[1];
        long x1 = rec1[2];
        long y1 = rec1[3];

        long x2 = rec2[0];
        long y2 = rec2[1];
        long x3 = rec2[2];
        long y3 = rec2[3];

        if (
                Math.abs((x3 + x2) - (x1 + x0)) < Math.abs(x1 - x0) + Math.abs(x3 - x2) &&
                        Math.abs((y3 + y2) - (y1 + y0)) < Math.abs(y1 - y0) + Math.abs(y3 - y2)
        ) {
            return true;
        }else return false;
    }
}

class Test{
    public static void main(String[] args) {
        boolean rectangleOverlap = new Solution().isRectangleOverlap(
                new int[]{0, 0, 1, 1},
                new int[]{1, 0, 2, 1}
        );
        System.out.println(rectangleOverlap);
    }
}