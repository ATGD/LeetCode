package Problem_1184_公交站间的距离;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int tmpPosition = start, leftDis = 0, rightDis = 0;
        for (; tmpPosition != destination; tmpPosition = (tmpPosition + 1) % distance.length)
            rightDis += distance[tmpPosition];
        tmpPosition = start;
        for (; tmpPosition != destination; tmpPosition = (tmpPosition - 1 + distance.length) % distance.length)
            leftDis += distance[(tmpPosition - 1 + distance.length) % distance.length];
        return Math.min(leftDis, rightDis);
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3);
        System.out.println(i);
    }
}