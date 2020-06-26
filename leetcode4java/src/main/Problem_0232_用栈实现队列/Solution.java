package Problem_0232_用栈实现队列;

import java.util.Stack;

class MyQueue {

    /**
     * Initialize your data structure here.
     */
    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> SecondStack = new Stack<>();

    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        firstStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (firstStack.size() > 0) SecondStack.push(firstStack.pop());
        int result = SecondStack.pop();
        while (SecondStack.size() > 0) firstStack.push(SecondStack.pop());
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (firstStack.size() > 0) SecondStack.push(firstStack.pop());
        int result = SecondStack.peek();
        while (SecondStack.size() > 0) firstStack.push(SecondStack.pop());
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return firstStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
