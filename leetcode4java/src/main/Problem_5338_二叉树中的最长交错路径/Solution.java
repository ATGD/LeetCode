package Problem_5338_二叉树中的最长交错路径;

import ext.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    Map<TreeNode, Integer[]> pathLengths = new HashMap<>();
    int count = 0;

    public int longestZigZag(TreeNode root) {
        recursionTreeNode(root);
        return count - 1;
    }

    private void recursionTreeNode(TreeNode root) {
        if (root == null) return;
        count = Math.max(count, countNodeLength(root, true));
        count = Math.max(count, countNodeLength(root, false));
        recursionTreeNode(root.left);
        recursionTreeNode(root.right);
    }

    private int countNodeLength(TreeNode treeNode, boolean isLeft) {
        if (treeNode == null) return 0;
        Integer[] path = pathLengths.get(treeNode);
        if (path != null && path[isLeft ? 0 : 1] != null) {
            return path[isLeft ? 0 : 1];
        } else {
            int length = 1 + countNodeLength(isLeft ? treeNode.right : treeNode.left, !isLeft);
            if (path == null) {
                path = new Integer[2];
                pathLengths.put(treeNode, path);
            }
            path[isLeft ? 0 : 1] = length;
        }
        return path[isLeft ? 0 : 1];
    }
}