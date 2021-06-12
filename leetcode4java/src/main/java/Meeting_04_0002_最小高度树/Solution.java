package Meeting_04_0002_最小高度树;


import ext.TreeNode;

import java.util.Arrays;

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
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        Arrays.sort(nums);
        this.nums = nums;
        int mid = (nums.length) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        setTree(node, 0, mid - 1, true);
        setTree(node, mid + 1, nums.length - 1, false);
        return node;
    }

    private void setTree(TreeNode node, int start, int end, boolean isLeft) {
        if (start > end) return;
        int mid = (end - start) / 2 + start;
        if (isLeft) {
            node.left = new TreeNode(nums[mid]);
            setTree(node.left, start, mid - 1, true);
            setTree(node.left, mid + 1, end, false);
        } else {
            node.right = new TreeNode(nums[mid]);
            setTree(node.right, start, mid - 1, true);
            setTree(node.right, mid + 1, end, false);
        }
    }

}