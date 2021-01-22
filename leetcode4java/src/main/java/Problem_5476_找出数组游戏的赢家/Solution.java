package Problem_5476_找出数组游戏的赢家;

import java.util.LinkedList;

class Solution {
    public int getWinner(int[] arr, int k) {
        if (k > arr.length) k = arr.length;
        boolean isFirst = true;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> exList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) exList.addLast(arr[i]);
        while (!exList.isEmpty()) {
            Integer nextCmpl = exList.pollFirst();
            if (list.isEmpty()) {
                list.addLast(nextCmpl);
            } else {
                Integer firstCmpl = list.peekFirst();
                if (firstCmpl == nextCmpl) throw new IllegalArgumentException("参数不合法");
                if (firstCmpl < nextCmpl) {
                    isFirst = false;
                    while (!list.isEmpty()) exList.offerLast(list.pollFirst());
                    list.addLast(nextCmpl);
                    exList.addLast(firstCmpl);
                }
                if (firstCmpl > nextCmpl) list.addLast(nextCmpl);
            }
            if (isFirst) {
                if (list.size() > k) {
                    return list.peekFirst();
                }
            } else if (list.size() >= k) {
                if (list.size() >= k) {
                    return list.pollFirst();
                }
            }
        }
        return list.pollFirst();
    }
}

class Test {
    public static void main(String[] args) {
        int winner = new Solution().getWinner(
                new int[]{
                        2,1,3,5,4,6,7
                }, 2
        );
        System.out.println(winner);
    }
}