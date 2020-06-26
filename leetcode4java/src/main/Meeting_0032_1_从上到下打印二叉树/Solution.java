package Meeting_0032_1_从上到下打印二叉树;

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
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> nodeList = new LinkedList<>();
        if (root == null) return new int[0];
        nodeList.add(root);
        while (nodeList.size() != 0) {
            int size = nodeList.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = nodeList.poll();
                list.add(tmpNode.val);
                if (tmpNode.left != null) nodeList.offer(tmpNode.left);
                if (tmpNode.right != null) nodeList.offer(tmpNode.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}