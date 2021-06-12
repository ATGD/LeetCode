package Problem_5731_座位预约管理系统;

import java.util.PriorityQueue;

class SeatManager {

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int reserve() {
        return queue.poll();
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */