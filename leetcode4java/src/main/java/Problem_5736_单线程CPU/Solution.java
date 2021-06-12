package Problem_5736_单线程CPU;

import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        TreeMap<Integer, List<Task>> taskMap = new TreeMap<>((o1, o2) -> o1 - o2);
        Queue<List<Task>> taskQueue = new PriorityQueue<>((o1, o2) -> o1.get(0).enqueueTime - o2.get(0).enqueueTime);

        PriorityQueue<Task> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.processingTime == o2.processingTime) {
                return o1.num - o2.num;
            }
            return o1.processingTime - o2.processingTime;
        });

        for (int i = 0; i < tasks.length; i++) {
            int[] tmpTask = tasks[i];
            List<Task> enqueuInThisTimeTasks = taskMap.get(tmpTask[0]);
            if (enqueuInThisTimeTasks == null) enqueuInThisTimeTasks = new ArrayList<>();
            enqueuInThisTimeTasks.add(new Task(tmpTask[0], tmpTask[1], i));
            taskMap.put(tmpTask[0], enqueuInThisTimeTasks);
        }

        int[] res = new int[tasks.length];
        int tmpIndex = 0;
        if (res.length == 0) return res;

        for (Map.Entry<Integer, List<Task>> next : taskMap.entrySet()) {
            taskQueue.add(next.getValue());
        }

        int time = 0;

        while (taskQueue.size() > 0 || queue.size() > 0) {
            List<Task> tmpTask = taskQueue.peek();
            if (tmpTask != null) {
                if (queue.size() == 0) {
                    time = Math.max(tmpTask.get(0).enqueueTime, time);
                }
                if (tmpTask.get(0).enqueueTime <= time) {
                    tmpTask = taskQueue.poll();
                    for (Task task : tmpTask) {
                        queue.offer(task);
                    }
                    continue;
                }
            }
            if (queue.size() != 0) {
                Task poll = queue.poll();
                res[tmpIndex++] = poll.num;
                time += poll.processingTime;
            }
        }
        return res;
    }

    class Task {
        int enqueueTime;
        int processingTime;
        int num;

        public Task(int enqueueTime, int processingTime, int num) {
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.num = num;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] order = new Solution().getOrder(
                new int[][]{
                        {1, 2},
                        {2, 4},
                        {3, 2},
                        {4, 1}
                }
        );
        System.out.println(order);
    }
}