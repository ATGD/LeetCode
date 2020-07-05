package Problem_0700_二叉搜索树中的搜索;


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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode tempNode = root;
        while (tempNode != null) {
            if (tempNode.val == val) return tempNode;
            if (tempNode.val < val) tempNode = tempNode.left;
            else tempNode = tempNode.right;
        }
        return null;
    }
}

class Test {
    public static void main(String[] args) {

    }
}



