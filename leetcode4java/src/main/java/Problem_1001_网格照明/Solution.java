package Problem_1001_网格照明;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] results = new int[queries.length];
        return results;
    }
}


class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().gridIllumination(10,
                new int[][]{
                        {0, 0}, {0, 4}
                }, new int[][]{
                        {0, 4}, {0, 1}, {1, 4}
                }
        );
        System.out.println(ints);
    }
}

