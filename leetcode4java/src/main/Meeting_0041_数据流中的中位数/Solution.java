package Meeting_0041_数据流中的中位数;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MedianFinder {


    List<Double> list = new ArrayList<>(50000);

    //if (n&1) == 1  n/2
    //if (n&1) ==0  (n-1)/2 n/2

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (list.size() == 0) {
            list.add((double) num);
            return;
        }
        int start = 0;
        int end = list.size() - 1;
        boolean hasAdd = false;
        while (start <= end) {
            if (list.get(start) >= num) {
                list.add(start, (double) num);
                hasAdd = true;
                break;
            } else if (list.get(end) <= num) {
                list.add(end + 1, (double) num);
                hasAdd = true;
                break;
            } else {
                int mid = (start + end) / 2;
                Double value = list.get(mid);
                if (value == num) {
                    list.add(mid, (double) num);
                    hasAdd = true;
                    break;
                } else if (value < num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        if (!hasAdd) {
            list.add(start, (double) num);
        }
//        for (; start < list.size(); start++) {
//            if (list.get(start) <= num)
//                break;
//        }
//        list.add(start, (double) num);
    }

    public double findMedian() {
        return (list.get((list.size() - 1) / 2) + list.get(list.size() / 2)) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

class Test {
    public static void main(String[] args) {
//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        medianFinder.addNum(7);
//        medianFinder.addNum(3);
////        medianFinder.list.add(-4);
////        medianFinder.addNum(-3);
//        medianFinder.findMedian();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.add(1);
        queue.add(2);
        queue.add(7);
        queue.add(3);
        System.out.println();
    }
}