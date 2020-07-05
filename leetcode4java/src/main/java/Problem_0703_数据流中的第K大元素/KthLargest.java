package Problem_0703_数据流中的第K大元素;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
    Integer cache = null;
    int k;

    public KthLargest(int k, int[] nums) {
        for (int num : nums) queue.offer(num);
        this.k = k;
    }

    public int add(int val) {
        if (cache != null && cache > val) return cache;
        queue.offer(val);
        Iterator<Integer> iterator = queue.iterator();
        int tmpValue = 0;
        for (int i = 0; i < k; i++) tmpValue = iterator.next();
        cache = tmpValue;
        return tmpValue;
    }
}

class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.offer(1);
        queue.offer(50);
        queue.offer(25);
        queue.offer(15);
        Iterator<Integer> iterator = queue.iterator();
        Object[] objects = queue.toArray();
        System.out.println(queue);
    }
}

