package Problem_5402_绝对差不超过限制的最长连续子数组;

import java.util.PriorityQueue;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length <= 1) return nums.length;
        PriorityQueue<Entry> queueMin = new PriorityQueue<>((o1, o2) -> {
            if (o1.value == o2.value) return o2.index - o1.index;
            return o1.value - o2.value;
        });
        PriorityQueue<Entry> queueMax = new PriorityQueue<>((o1, o2) -> {
            if (o1.value == o2.value) return o2.index - o1.index;
            return o2.value - o1.value;
        });
        int start = 0, end = 0, maxLength = 0;
        Entry e = new Entry(nums[0], 0);
        queueMin.offer(e);
        queueMax.offer(e);
        while (end < nums.length) {
            if (start == end) {
                end++;
                continue;
            }
            Entry tmpEntry = new Entry(nums[end], end);
            queueMin.offer(tmpEntry);
            queueMax.offer(tmpEntry);
            Entry peekMin = queueMin.peek();
            Entry peekMax = queueMax.peek();
            if (peekMax.value - peekMin.value > limit) {
                int index = Math.min(peekMax.index, peekMin.index);
                queueMin.removeIf(entry -> entry.index <= index);
                queueMax.removeIf(entry -> entry.index <= index);
                start = index + 1;
            } else {
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            }
        }
        return maxLength;
    }

    class Entry {
        int value = 0;
        int index = 0;

        public Entry(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().longestSubarray(new int[]{
//                        7, 40, 10, 10, 40, 39, 96, 21, 54, 73, 33, 17, 2, 72, 5, 76, 28, 73, 59, 22, 100, 91, 80, 66, 5, 49, 26, 45, 13, 27, 74, 87, 56, 76, 25, 64, 14, 86, 50, 38, 65, 64, 3, 42, 79, 52, 37, 3, 21, 26, 42, 73, 18, 44, 55, 28, 35, 87
                8,2,4,7
                },

                4);
        System.out.println(i);
    }
}