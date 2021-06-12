package Problem_0226_翻转二叉树;

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempNode);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution.TreeNode treeNode1 = new Solution.TreeNode(1);
        Solution.TreeNode treeNode2 = new Solution.TreeNode(2);
        Solution.TreeNode treeNode3 = new Solution.TreeNode(3);
        Solution.TreeNode treeNode4 = new Solution.TreeNode(4);
        Solution.TreeNode treeNode5 = new Solution.TreeNode(5);
        Solution.TreeNode treeNode6 = new Solution.TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode6;
        Solution.TreeNode treeNode = new Solution().invertTree(treeNode1);
        System.out.println(treeNode);
    }
}

