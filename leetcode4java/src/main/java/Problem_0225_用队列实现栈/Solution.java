package Problem_0225_用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    /**
     * Initialize your data structure here.
     */
    Queue<Integer> queue;
    Queue<Integer> assistQueue;

    public MyStack() {
        queue = new LinkedList<>();
        assistQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int result = 0;
        while (queue.size() != 1) {
            assistQueue.offer(queue.poll());
        }
        result = queue.poll();
        while (assistQueue.size() != 0) {
            queue.offer(assistQueue.poll());
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int result = 0;
        while (queue.size() != 0) {
            int poll = queue.poll();
            result = poll;
            assistQueue.offer(poll);
        }
        while (assistQueue.size() != 0) {
            queue.offer(assistQueue.poll());
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */