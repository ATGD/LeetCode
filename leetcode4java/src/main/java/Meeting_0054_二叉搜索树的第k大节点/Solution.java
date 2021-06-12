package Meeting_0054_二叉搜索树的第k大节点;

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
    int k;
    int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.right);
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}