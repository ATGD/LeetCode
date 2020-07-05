package Problem_0155_最小栈;

import Problem_0038_报数.Solution;

class MinStack {

    /**
     * initialize your data structure here.
     */
    Integer min = null;
    int[] entryArray;

    public MinStack() {
        entryArray = new int[0];
    }

    public void push(int x) {
        int[] tempEntryArray = new int[entryArray.length + 1];
        System.arraycopy(entryArray, 0, tempEntryArray, 0, entryArray.length);
        tempEntryArray[tempEntryArray.length - 1] = x;
        entryArray = tempEntryArray;
        if (min == null || x < min) {
            min = x;
        }
    }

    public void pop() {
        if (entryArray.length == 0)
            return;
        int[] tempEntryArray = new int[entryArray.length - 1];
        System.arraycopy(entryArray, 0, tempEntryArray, 0, entryArray.length - 1);
        entryArray = tempEntryArray;
        min = null;
        for (int i = 0; i < entryArray.length; i++) {
            if (min == null || entryArray[i] < min) {
                min = entryArray[i];
            }
        }
    }

    public int top() {
        return entryArray[entryArray.length-1];
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class Test{
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min1 = minStack.getMin();
        System.out.println();
    }
}

