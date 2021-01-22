package Problem_5653_可以形成最大正方形的矩形数目;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {

            int aryMin = Math.min(rectangle[0], rectangle[1]);

            Integer count = map.get(aryMin);
            if (count == null) count = 0;

            count++;
            map.put(aryMin, count);
            max = Math.max(max, aryMin);
        }
        return map.get(max);
    }
}