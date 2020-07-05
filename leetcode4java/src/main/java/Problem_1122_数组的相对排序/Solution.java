package Problem_1122_数组的相对排序;

import java.util.PriorityQueue;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int i : arr1) bucket[i]++;
        int index = 0;
        for (int value : arr2) while (bucket[value]-- > 0) arr1[index++] = value;
        for (int i = 0; i < bucket.length; i++) while (bucket[i]-- > 0) arr1[index++] = i;
        return arr1;
    }
}

class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        queue.offer(432);
        queue.offer(34);
        queue.offer(234);
        queue.offer(24);
        queue.offer(234);
        queue.offer(242);
    }
}
