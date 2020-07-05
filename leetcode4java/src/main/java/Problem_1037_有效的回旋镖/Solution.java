package Problem_1037_有效的回旋镖;

class Solution {
    public boolean isBoomerang(int[][] points) {
        float x1 = points[0][0];
        float x2 = points[1][0];
        float x3 = points[2][0];
        float y1 = points[0][1];
        float y2 = points[1][1];
        float y3 = points[2][1];
        return !((y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1));
    }
}

class Test {
    public static void main(String[] args) {

    }
}
