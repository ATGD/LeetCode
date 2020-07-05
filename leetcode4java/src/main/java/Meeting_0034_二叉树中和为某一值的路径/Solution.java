package Meeting_0034_二叉树中和为某一值的路径;

import ext.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> pathList = new ArrayList<>();
        if (root == null) return result;
        recursionTree(root, pathList, sum, 0);
        return result;
    }

    private void recursionTree(TreeNode root, List<Integer> pathList, int sum, int currentValue) {
        if (root == null) return;
        pathList.add(root.val);
        currentValue += root.val;
        if (root.left == null && root.right == null) {
            if (sum == currentValue) {
                result.add(new ArrayList<>(pathList));
                return;
            }
        } else {
            if (root.left != null) {
                recursionTree(root.left, pathList, sum, currentValue);
                pathList.remove(pathList.size() - 1);
            }
            if (root.right != null) {
                recursionTree(root.right, pathList, sum, currentValue);
                pathList.remove(pathList.size() - 1);
            }
        }
    }
}
