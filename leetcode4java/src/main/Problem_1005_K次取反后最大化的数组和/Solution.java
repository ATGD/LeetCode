package Problem_1005_K次取反后最大化的数组和;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> aqueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < A.length; i++) {
            aqueue.offer(A[i]);
        }
        int count = 0;
        while (K > 0 && aqueue.peek() < 0) {
            Integer poll = aqueue.poll();
            aqueue.offer(-poll);
            K--;
        }
        if (K > 0) {
            if ((K & 1) == 1) {
                Integer poll = aqueue.poll();
                aqueue.offer(-poll);
            }
        }
        Iterator<Integer> iterator = aqueue.iterator();
        while (iterator.hasNext()) {
            count += iterator.next();
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6);
        System.out.println(i);
    }
}

