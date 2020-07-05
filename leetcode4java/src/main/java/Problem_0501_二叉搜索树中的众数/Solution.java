package Problem_0501_二叉搜索树中的众数;


import ext.TreeNode;

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
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        map.clear();
        maxCount = 0;
        List<Integer> resultList = new ArrayList<>();
        travelTree(root);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) resultList.add(entry.getKey());
        }
        int[] results = new int[resultList.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = resultList.get(i);
        }
        return results;
    }

    private void travelTree(TreeNode root) {
        if (root == null) return;
        travelTree(root.left);
        Integer tmpCount = map.get(root.val);
        if (tmpCount == null) {
            map.put(root.val, 1);
            maxCount = Math.max(maxCount, 1);
        } else {
            map.put(root.val, tmpCount + 1);
            maxCount = Math.max(maxCount, tmpCount + 1);
        }
        travelTree(root.right);
    }
}