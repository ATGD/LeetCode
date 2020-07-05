package Problem_0933_最近的请求次数;

import java.util.LinkedList;

class RecentCounter {

    LinkedList<Integer> timeStampList = new LinkedList<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        timeStampList.add(t);
        while (timeStampList.peekFirst() < t - 3000) {
            timeStampList.pollFirst();
        }
        return timeStampList.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */


class Test {
    public static void main(String[] args) {

    }
}

