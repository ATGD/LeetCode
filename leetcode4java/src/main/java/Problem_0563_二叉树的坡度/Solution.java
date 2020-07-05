package Problem_0563_二叉树的坡度;

import ext.TreeNode;

class Solution {
    int sumTilt = 0;

    public int findTilt(TreeNode root) {
        sumTilt = 0;
        getSum(root);
        return sumTilt;
    }

    private int getSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        sumTilt += Math.abs(left - right);
        return root.val + left + right;
    }

}