package Sword_Offer_0055_I_二叉树的深度;

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

    int maxDeep = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxDeep;
    }

    private void dfs(TreeNode root, int tmpDeep) {
        if (root == null) return;
        dfs(root.left, ++tmpDeep);
        maxDeep = Math.max(maxDeep, tmpDeep);
        dfs(root.right, tmpDeep);
    }

}


