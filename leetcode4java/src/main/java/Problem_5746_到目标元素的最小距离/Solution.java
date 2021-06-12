package Problem_5746_到目标元素的最小距离;

import java.util.*;

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            List<Integer> integers = map.get(value);

            if (integers == null)
                integers = new ArrayList<>();

            integers.add(i);
            map.put(value, integers);
        }

        List<Integer> targetList = map.get(target);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < targetList.size(); i++) {
            queue.add(Math.abs(targetList.get(i) - start));
        }
        return queue.poll();
    }
}

class Test {
    public static void main(String[] args) {
        int minDistance = new Solution().getMinDistance(new int[]{
                5, 2, 3, 5, 5
        }, 5, 2);
        System.out.println(minDistance);
    }
}