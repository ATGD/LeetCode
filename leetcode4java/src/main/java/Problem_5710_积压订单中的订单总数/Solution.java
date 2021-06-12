package Problem_5710_积压订单中的订单总数;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {

        PriorityQueue<int[]> buyQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < orders.length; i++) {
            int[] order = orders[i];
            if (order[2] == 1) {    //sell
                int[] buyOrderInQueue;
                while ((buyOrderInQueue = buyQueue.peek()) != null) {
                    if (buyOrderInQueue[0] >= order[0]) {    //price
                        if (buyOrderInQueue[1] <= order[1]) {
                            buyQueue.poll();
                            order[1] -= buyOrderInQueue[1];
                        } else {
                            buyOrderInQueue[1] -= order[1];
                            order[1] = 0;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (order[1] > 0) {
                    sellQueue.offer(order);
                }
            } else {
                int[] sellOrderInQueue;
                while ((sellOrderInQueue = sellQueue.peek()) != null) {
                    if (sellOrderInQueue[0] <= order[0]) {    //price
                        if (sellOrderInQueue[1] <= order[1]) {
                            sellQueue.poll();
                            order[1] -= sellOrderInQueue[1];
                        } else {
                            sellOrderInQueue[1] -= order[1];
                            order[1] = 0;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (order[1] > 0) {
                    buyQueue.offer(order);
                }
            }
        }

        long count = 0;
        while (buyQueue.size() > 0) {
            int[] poll = buyQueue.poll();
            count += poll[1];
        }
        while (sellQueue.size() > 0) {
            int[] poll = sellQueue.poll();
            count += poll[1];
        }
        return (int) (count % (1000000000 + 7));
    }
}

class Test {
    public static void main(String[] args) {
        int numberOfBacklogOrders = new Solution().getNumberOfBacklogOrders(
                new int[][]{
                        {7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}
                }
        );
        System.out.println(numberOfBacklogOrders);
    }
}