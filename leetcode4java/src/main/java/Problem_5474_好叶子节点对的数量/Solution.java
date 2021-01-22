package Problem_5474_好叶子节点对的数量;

import ext.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    int count = 0;
    int distance;

    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        this.distance = distance;
        traversalNode(root);
        return count;
    }

    private LeaveChilds traversalNode(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            return new LeaveChilds(list, 0);
        }
        LeaveChilds leftChilds = traversalNode(root.left);
        LeaveChilds rightChilds = traversalNode(root.right);
        if (leftChilds == null) {
            rightChilds.length++;
            return rightChilds;
        }
        if (rightChilds == null) {
            leftChilds.length++;
            return leftChilds;
        }
        ArrayList<Integer> mergeList = new ArrayList<>();
        for (int i = 0; i < leftChilds.list.size(); i++) {
            mergeList.add(leftChilds.list.get(i) + leftChilds.length + 1);
        }
        int leftSize = mergeList.size();
        for (int i = 0; i < rightChilds.list.size(); i++) {
            int rightDis = rightChilds.list.get(i) + rightChilds.length + 1;
            for (int j = 0; j < leftSize; j++) {
                if (mergeList.get(j) + rightDis <= distance) count++;
            }
            mergeList.add(rightDis);
        }
        return new LeaveChilds(mergeList, 0);
    }

    static class LeaveChilds {
        public LeaveChilds(List<Integer> list, int length) {
            this.list = list;
            this.length = length;
        }

        List<Integer> list;
        int length;
    }
}