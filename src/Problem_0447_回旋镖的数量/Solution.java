package Problem_0447_回旋镖的数量;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int resultCount = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distanceMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int distance2 = (int) (Math.pow(Math.abs(points[i][0] - points[j][0]), 2) + Math.pow(Math.abs(points[i][1] - points[j][1]), 2));
                if (distanceMap.containsKey(distance2)) distanceMap.put(distance2, distanceMap.get(distance2) + 1);
                else distanceMap.put(distance2, 1);
            }

            for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
                int itemCount = entry.getValue();
                if (itemCount > 1) resultCount += (itemCount * (itemCount - 1));
            }
        }
        return resultCount;
    }

}

class Test {
    public static void main(String[] args) {
        int day = 14;
        int result = ((int) (884.811188811163 + day * 80.0157342658672 + day * day * 246.982226107145 + day * day * day * (-15.5938228438075) + day * day * day * day * 0.628496503495621));
        System.out.println(day + "天后，确诊总人数为：" + result);
    }
}
