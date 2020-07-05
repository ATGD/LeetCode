package Problem_0110_平衡二叉树;

import ext.TreeNode;

class Solution {

    public boolean isBalanced(TreeNode root) {
        return isBalanceExecute(root);
    }

    private boolean isBalanceExecute(TreeNode root) {
        if (root == null)
            return true;
        int deepLeft = getDeep(root.left);
        int deepRight = getDeep(root.right);
        if (Math.abs(deepLeft - deepRight) > 1) {
            return false;
        }
        return isBalanced(root.left) & isBalanced(root.right);
    }

    private int getDeep(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getDeep(root.left), getDeep(root.right));
    }
}