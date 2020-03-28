package Meeting_0059_队列的最大值;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class MaxQueue {

    LinkedList<Integer> valueList = new LinkedList<>();
    Queue<Integer> maxList = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public MaxQueue() { }

    public int max_value() {
        return maxList.size() == 0?-1:maxList.peek();
    }

    public void push_back(int value) {
        maxList.add(value);
        valueList.addLast(value);

    }

    public int pop_front() {
        if (valueList.size() == 0) return -1;
        maxList.remove(valueList.peekFirst());
        return valueList.pollFirst();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

class Test{
    public static void main(String[] args) {
        Queue<Integer> maxList = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxList.add(1);
        maxList.add(1);
        maxList.add(1);
        maxList.add(3);
        maxList.add(4);
        maxList.remove(1);
        System.out.println(maxList.size());
    }
}