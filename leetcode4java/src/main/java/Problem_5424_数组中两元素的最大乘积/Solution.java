package Problem_5424_数组中两元素的最大乘积;

import java.util.PriorityQueue;

class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) queue.add(num-1);
        return queue.poll()*queue.poll();
    }
}

class Test{
    public static void main(String[] args) {
        int result = new Solution().maxProduct(new int[]{
                3, 4, 5, 2
        });
        System.out.println(result);
    }
}