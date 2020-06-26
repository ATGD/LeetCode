package Problem_0056_合并区间;

import java.io.Serializable;
import java.util.*;
import java.util.function.ToDoubleFunction;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][2];
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            return o2[1] - o1[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> resultList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                resultList.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        resultList.add(new int[]{left, right});
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] result = new Solution().merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {9, 15},
                {15, 18}
        });
        System.out.println(result);
    }
}
