package Problem_5418_二叉树中的伪回文路径;


import ext.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int[] path = new int[9];

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null)
            return 0;
        int tempCount = 0;
        path[root.val - 1]++;
        if (root.left == null && root.right == null) {
            if (isPalindromic()) tempCount++;
            path[root.val - 1]--;
            return tempCount;
        }
        if (root.left != null) tempCount += pseudoPalindromicPaths(root.left);
        if (root.right != null) tempCount += pseudoPalindromicPaths(root.right);
        path[root.val - 1]--;
        return tempCount;
    }

    private boolean isPalindromic() {
        int singleCount = 0;
        for (int i = 0; i < path.length; i++) {
            if ((path[i] & 1) == 1) singleCount++;
            if (singleCount > 1) return false;
        }
        return true;
    }
}