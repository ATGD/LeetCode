package Problem_0965_单值二叉树;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root.val, root);
    }

    boolean isUnivalTree(int val, TreeNode node) {
        if (node == null) return true;
        if (val != node.val) return false;
        return isUnivalTree(val, node.left) && isUnivalTree(val, node.right);
    }
}
