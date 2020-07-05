package Problem_5320_餐厅过滤器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> resList = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (restaurant[2] >= veganFriendly
                    && restaurant[3] <= maxPrice
                    && restaurant[4] <= maxDistance) {
                resList.add(restaurant);
            }
        }
        Collections.sort(resList, (o1, o2) -> {
            int i = o2[1] - o1[1];
            if (i == 0) return o2[0] - o1[0];
            return i;
        });
        List<Integer> resultList = new ArrayList<>();
        for (int[] ints : resList) resultList.add(ints[0]);
        return resultList;
    }
}
