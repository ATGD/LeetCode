package Problem_1302_层数最深叶子节点的和;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(100);
        int count = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int tempSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                tempSum += pop.val;
                if (pop.left != null)
                    queue.offer(pop.left);
                if (pop.right != null)
                    queue.offer(pop.right);
            }
            count = tempSum;
        }
        return count;
    }
}

