package Problem_5359_最大的团队表现值;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Queue<int[]> items = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < n; i++) items.offer(new int[]{speed[i], efficiency[i]});
        long sum = 0, res = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int[] item = items.poll();
            queue.add(item[0]);
            sum += item[0];
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            res = Math.max(res, sum * item[1]);
        }
        return (int) (res % 1000000007);
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxPerformance(
                6,
                new int[]{2, 10, 3, 1, 5, 8},
                new int[]{5, 4, 3, 9, 7, 2},
                3
        );
        System.out.println(1e9);
    }
}