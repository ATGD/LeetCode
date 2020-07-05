package Problem_0445_两数相加2;

import ext.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        addToStack(l1, stack1);
        addToStack(l2, stack2);
        int next = 0;//进位
        ListNode headNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || next != 0) {
            int leftOptNum = stack1.isEmpty() ? 0 : stack1.pop();
            int rightOptNum = stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode((leftOptNum + rightOptNum + next) % 10);
            next = (leftOptNum + rightOptNum + next) / 10;
            node.next = headNode;
            headNode = node;
        }
        return headNode;
    }

    private void addToStack(ListNode l1, Stack<Integer> stack1) {
        if (l1 != null) {
            stack1.add(l1.val);
            addToStack(l1.next, stack1);
        }
    }
}