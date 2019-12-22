package Problem_0682_棒球比赛;

import java.util.Stack;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> pointStack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                Integer one = pointStack.pop();
                Integer two = pointStack.pop();
                pointStack.push(two);
                pointStack.push(one);
                pointStack.push(one + two);
            } else if (op.equals("D")) {
                pointStack.push(pointStack.peek() * 2);
            } else if (op.equals("C"))
                pointStack.pop();
            else {
                pointStack.push(Integer.parseInt(op));
            }
        }
        int pointCount = 0;
        while (pointStack.size() > 0) {
            pointCount += pointStack.pop();
        }
        return pointCount;
    }
}