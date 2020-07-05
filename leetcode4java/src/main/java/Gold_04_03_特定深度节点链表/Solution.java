package Gold_04_03_特定深度节点链表;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import ext.ListNode;
import ext.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = new ListNode(0);
            ListNode node = head;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                node.next = new ListNode(poll.val);
                node = node.next;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            resultList.add(head.next);
        }
        return resultList.toArray(new ListNode[resultList.size()]);
    }
}