package Problem_0543_二叉树的直径;

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        maxDeep(max, root);
        return max[0];
    }

    private int maxDeep(int[] max, TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        int leftDeep = maxDeep(max, treeNode.left);
        int rightDeep = maxDeep(max, treeNode.right);
        int maxChild = Math.max(leftDeep, rightDeep);
        if (max[0] < leftDeep + rightDeep) {
            max[0] = leftDeep + rightDeep;
        }
        return maxChild + 1;
    }

    public class TreeNode {
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

