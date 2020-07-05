package Problem_0437_路径总和3_unsolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return pathSumTo(root, 0, sum, map);
    }

    private int pathSumTo(TreeNode curNode, int curSum, int target, Map<Integer, Integer> map) {
        if (curNode == null) return 0;
        curSum += curNode.val;
        int validPathToCurNode = map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        validPathToCurNode += pathSumTo(curNode.left, curSum, target, map) + pathSumTo(curNode.right, curSum, target, map);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
        return validPathToCurNode;
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

