package Problem_1029_两地调度;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int twoCitySchedCost(int[][] costs) {
        if (costs.length == 0) return 0;
        List<int[]> list = new ArrayList<>();
        for (int[] cost : costs)
            list.add(cost.clone());
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (Math.abs(o1[0] - o1[1]) - Math.abs(o2[0] - o2[1]) == 0) {
                    return o1[0] - o1[1];
                }
                return Math.abs(o1[0] - o1[1]) - Math.abs(o2[0] - o2[1]);
            }
        });
        int sum = 0;
        int A = 0;
        int B = 0;
        int N = costs.length / 2;
        for (int i = list.size() - 1; i >= 0; i--) {
            int[] temp = list.get(i);
            if (temp[0] > temp[1]) {
                if (B < N) {
                    sum += temp[1];
                    B++;
                } else {
                    sum += temp[0];
                    A++;
                }
            } else {
                if (A < N) {
                    sum += temp[0];
                    A++;
                } else {
                    sum += temp[1];
                    B++;
                }
            }
        }
        return sum;
    }

}

class Test {
    public static void main(String[] args) {
        int i = new Solution().twoCitySchedCost(new int[][]{
                {10, 20},
                {30, 200},
                {400, 50},
                {60, 20}
        });
        System.out.println(i);
    }
}
