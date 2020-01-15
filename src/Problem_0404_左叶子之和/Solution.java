package Problem_0404_左叶子之和;

import ext.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) return 0;
//        int sum = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (queue.size() > 0) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                TreeNode left = poll.left;
//                TreeNode right = poll.right;
//                if (left != null) {
//                    if (left.left == null && left.right == null)
//                        sum += left.val;
//                    queue.offer(left);
//                }
//                if (right != null)
//                    queue.offer(right);
//            }
//        }
//        return sum;
        if (root == null)
            return 0;
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeftNode) {
        if (root == null)
            return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int sum = 0;
        if (isLeftNode && left == null && right == null)
            sum += root.val;
        return sum
                + sumOfLeftLeaves(root.left, true)
                + sumOfLeftLeaves(root.right, false);
    }
}
