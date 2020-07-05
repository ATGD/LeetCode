package Problem_1022_从根到叶的二进制数之和;

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

    long molNum = molNum();

    public int sumRootToLeaf(TreeNode root) {
        return (int) calculateLeaf(root, 0L);
    }

    private long calculateLeaf(TreeNode root, long nowValue) {
        if (root == null) return 0;
        nowValue = ((nowValue << 1) + root.val);
        nowValue = nowValue % molNum;
        long left = 0, right = 0;
        if (root.left == null && root.right == null) return nowValue;
        if (root.left != null) left = calculateLeaf(root.left, nowValue) % molNum;
        if (root.right != null) right = calculateLeaf(root.right, nowValue) % molNum;
        long resultValue = (left + right) % molNum;
        return resultValue;
    }

    private long molNum() {
        long base = 1;
        for (int i = 0; i < 9; i++) base *= 10;
        return base + 7;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long molNum = solution.molNum;
        System.out.println(molNum);
    }
}