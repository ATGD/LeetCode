package Problem_1266_访问所有点的最小时间;

class Solution {
    //    public int minTimeToVisitAllPoints(int[][] points) {
//        int[] tempPos = new int[2];
//        int count = 0;
//        for (int i = 0; i < points.length; i++) {
//            if (i != 0) {
//                int distanceX = Math.abs(points[i][0] - tempPos[0]);
//                int distanceY = Math.abs(points[i][1] - tempPos[1]);
//                count = count + Math.abs(distanceY - distanceX) + Math.min(distanceX,distanceY);
//            }
//            tempPos[0] = points[i][0];
//            tempPos[1] = points[i][1];
//        }
//        return count;
//    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return sum;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().minTimeToVisitAllPoints(new int[][]{
                {1, 1},
                {3, 4},
                {-1, 0}
        });
        System.out.println(i);
    }
}

