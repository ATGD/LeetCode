package Problem_0102_二叉树的层序遍历;

import ext.TreeNode;

import java.util.*;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int queueSize = queue.size();
            List<Integer> itemList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode pollNode = queue.poll();
                itemList.add(pollNode.val);
                if (pollNode.left != null)
                    queue.offer(pollNode.left);
                if (pollNode.right != null)
                    queue.offer(pollNode.right);
            }
            result.add(itemList);
        }
        return result;
    }
}
