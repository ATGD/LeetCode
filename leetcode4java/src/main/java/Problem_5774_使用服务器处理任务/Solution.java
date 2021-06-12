package Problem_5774_使用服务器处理任务;

import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {

    //服务器空闲队列
    PriorityQueue<int[]> adleQueue = new PriorityQueue<>((t0, t1) -> {
        if ((t0[0] - t1[0]) == 0) return t0[1] - t1[1];
        return t0[0] - t1[0];
    });

    //任务等待队列
    LinkedList<int[]> waitQueue = new LinkedList<>();
    //服务器繁忙队列
    PriorityQueue<TaskEntry> busyQueue = new PriorityQueue<>((t0, t1) -> t0.EndTime - t1.EndTime);

    public int[] assignTasks(int[] servers, int[] tasks) {

        int[] res = new int[tasks.length];

        for (int i = 0; i < servers.length; i++)
            adleQueue.add(new int[]{servers[i], i});

        int wordTime = 0;

        while (!waitQueue.isEmpty() || (wordTime == 0 || wordTime < tasks.length)) {
            if (wordTime < tasks.length) {
                waitQueue.add(new int[]{wordTime, tasks[wordTime]});
            }

            //繁忙队列中完成任务的出栈
            while (!busyQueue.isEmpty()) {
                TaskEntry peek = busyQueue.peek();
                if (peek.EndTime <= wordTime) {
                    adleQueue.add(busyQueue.poll().serverEntry);
                } else {
                    break;
                }
            }

            if (!adleQueue.isEmpty()) {
                int[] server = adleQueue.poll();
                int[] task = waitQueue.poll();

                res[task[0]] = server[1];

                busyQueue.add(new TaskEntry(server, wordTime + task[1]));
            }

            //时间累加
            wordTime++;
        }

        return res;
    }

    class TaskEntry {
        public TaskEntry(int[] serverEntry, int endTime) {
            this.serverEntry = serverEntry;
            EndTime = endTime;
        }

        int[] serverEntry;
        int EndTime;
    }
//    [26,50,47,11,56,31,18,55,32,9,4,2,23,53,43,0,44,30,6,51,29,51,15,17,22,34,38,33,42,3,25,10,49,51,7,58,16,21,19,31,19,12,41,35,45,52,13,59,47,36,1,28,48,39,24,8,46,20,5,54,27,37,14,57,40,59,8,45,4,51,47,7,58,4,31,23,54,7,9,56,2,46,56,1,17,42,11,30,12,44,14,32,7,10,23,1,29,27,6,10,33,24,19,10,35,30,35,10,17,49,50,36,29,1,48,44,7,11,24,57,42,30,10,55,3,20,38,15,7,46,32,21,40,16,59,30,53,17,18,22,51,11,53,36,57,26,5,36,56,55,31,34,57,7,52,37,31,10,0,51,41,2,32,25,0,7,49,47,13,14,24,57,28,4,45,43,39,38,8,2,44,45,29,25,25,12,54,5,44,30,27,23,26,7,33,58,41,25,52,40,58,9,52,40]
//    [26,50,47,11,56,31,18,55,32,9,4,2,23,53,43,0,44,30,6,51,29,51,15,17,22,34,38,33,42,3,25,10,49,51,7,58,16,21,19,31,19,12,41,35,45,52,13,59,47,36,1,28,48,39,24,8,46,20,5,54,27,37,14,57,40,59,8,45,4,51,47,7,58,4,31,23,54,7,9,56,2,46,56,1,17,42,11,30,12,44,14,32,7,10,23,1,29,27,6,10,33,24,19,10,35,30,35,10,17,49,50,36,29,1,48,44,7,11,24,57,42,30,10,55,3,20,38,15,7,46,32,21,40,16,59,30,53,17,18,22,51,11,53,36,57,26,5,56,36,55,31,34,57,7,52,37,31,10,0,51,41,2,32,25,0,7,49,47,13,14,24,57,28,4,45,43,39,38,8,2,44,45,29,25,25,12,54,5,44,30,27,23,26,7,33,58,41,25,52,40,58,9,52,40]
}