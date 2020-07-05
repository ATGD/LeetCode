package Problem_5354_通知所有员工所需的时间;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int times = 0;
        for (int i = 0; i < informTime.length; i++) {
            if (informTime[i] == 0) {
                int index = i;
                int tmpTime = 0;
                while (index != -1) {
                    tmpTime += informTime[index];
                    index = manager[index];
                }
                times = Math.max(times, tmpTime);
            }
        }
        return times;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numOfMinutes(11, 4, new int[]{
                5, 9, 6, 10, -1, 8, 9, 1, 9, 3, 4
        }, new int[]{
                0, 213, 0, 253, 686, 170, 975, 0, 261, 309, 337
        });
        System.out.println(i);
    }
}