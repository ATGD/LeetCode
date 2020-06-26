package Problem_5170_验证二叉树;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        for (int i : leftChild) if (i == 0) return false;
        for (int i : rightChild) if (i == 0) return false;
        Set<Integer> nodeSet = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer index = queue.pollFirst();
                if (index > leftChild.length - 1) continue;
                if (nodeSet.contains(index)) return false;
                nodeSet.add(index);
                if (leftChild[index] != -1) {
                    queue.addLast(leftChild[index]);
                }
                if (rightChild[index] != -1) {
                    queue.addLast(rightChild[index]);
                }
            }
        }
        return nodeSet.size() == n;
    }
}

class Test{
    public static void main(String[] args) {
        boolean b = new Solution().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1});
        System.out.println(b);
    }
}
