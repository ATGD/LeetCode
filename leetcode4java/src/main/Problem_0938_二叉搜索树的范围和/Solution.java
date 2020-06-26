package Problem_0938_二叉搜索树的范围和;

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

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int value = 0;
        int tempValue = root.val;
        if (tempValue >= L && tempValue <= R) value += tempValue;
        if (tempValue <= L) return value + rangeSumBST(root.right, L, R);
        else if (tempValue >= R) return value + rangeSumBST(root.left, L, R);
        else return value + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

