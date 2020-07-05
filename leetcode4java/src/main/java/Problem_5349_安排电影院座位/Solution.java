package Problem_5349_安排电影院座位;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, boolean[]> map = new HashMap();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int column = reservedSeats[i][1];
            boolean[] ints = map.get(row);
            if (ints == null) {
                ints = new boolean[3];
                map.put(row, ints);
            }
            if (column >= 2 && column <= 5) ints[0] = true;
            if (column >= 4 && column <= 7) ints[1] = true;
            if (column >= 6 && column <= 9) ints[2] = true;
        }
        int count = n * 2;
        Set<Map.Entry<Integer, boolean[]>> entries = map.entrySet();
        for (Map.Entry<Integer, boolean[]> entry : entries) {
            boolean[] row = entry.getValue();
            if (!row[0] & !row[2]) continue;
            if (!row[0] | !row[1] | !row[2]) count--;
            else count-=2;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxNumberOfFamilies(3, new int[][]{
                {1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}
        });
        System.out.println(i);
    }
}