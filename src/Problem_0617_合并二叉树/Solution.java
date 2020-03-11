package Problem_0617_合并二叉树;

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            TreeNode  tempNode = new TreeNode(t1.val + t2.val);
            tempNode.left = mergeTrees(t1.left, t2.left);
            tempNode.right = mergeTrees(t1.right, t2.right);
            return tempNode;
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
}

class Test {
    //0,1,1,2,3,5,8
    public static void main(String[] args) {

    }
}

