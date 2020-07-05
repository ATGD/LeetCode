package Problem_5339_二叉搜索子树的最大键值和;

import ext.TreeNode;

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
    int count = 0;

    public int maxSumBST(TreeNode root) {
        int result = countSearchTree(root, 0, null, true);
        count = Math.max(result, count);
        recursionTree(root);
        return count;
    }

    /*
    遍历所有树，如果是符合二叉搜树，就进行计算最小二叉树
     */
    private void recursionTree(TreeNode root) {
        if (root == null) return;
        int val = root.val;
        count = Math.max(countSearchTree(root, 0, null, true) + root.val, count);
        if (root.left != null && root.left.val >= root.val) recursionTree(root.left);
        if (root.right != null && root.right.val <= root.val) recursionTree(root.right);
    }

    private int countSearchTree(TreeNode root, int sum, TreeNode parentNode, boolean isLeft) {
        if (root != null) {
            if (parentNode == null || (isLeft && parentNode.val > root.val) || (!isLeft && parentNode.val < root.val)) {
                sum += root.val;
                countSearchTree(root.left, sum, root, true);
                countSearchTree(root.right, sum, root, false);
            }
        }
        return sum;
    }
}