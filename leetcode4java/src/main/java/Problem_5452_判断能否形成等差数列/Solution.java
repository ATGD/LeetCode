package Problem_5452_判断能否形成等差数列;

import java.util.PriorityQueue;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) queue.offer(i);
        int tmp = queue.poll();
        Integer base = null;
        while (queue.peek() != null) {
            Integer poll = queue.poll();
            if (base == null) {
                base = poll - tmp;
            } else {
                if (poll - tmp != base)
                    return false;
            }
            tmp = poll;
        }
        return true;
    }
}

class Test{
    public static void main(String[] args) {
        boolean result = new Solution().canMakeArithmeticProgression(new int[]{
                1, 3, 5, 7, 9
        });
        System.out.println(result);
    }
}