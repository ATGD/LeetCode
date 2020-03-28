package Problem_5342_最多可以参加的会议数目;

class Solution {
//    Integer[] dp;

    public int maxEvents(int[][] events) {
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
//        dp = new Integer[maxDay];
        int[] work = new int[events.length];
        return getMaxEvents(events, 1, maxDay, work);
    }

    private int getMaxEvents(int[][] events, int day, int maxDay, int[] work) {
        if (day > maxDay) return 0;
//        if (dp[day - 1] != null) return dp[day - 1];
        int maxTmp = 0;
        for (int j = 0; j < events.length; j++) {
            int[] copyWork = work.clone();
            if (day >= events[j][0] && day <= events[j][1] && work[j] != 1) {
                copyWork[j] = 1;
                maxTmp = Math.max(maxTmp, 1 + getMaxEvents(events, day + 1, maxDay, copyWork));
            } else {
                maxTmp = Math.max(maxTmp, getMaxEvents(events, day + 1, maxDay, copyWork));
            }
        }

//        dp[day - 1] = maxTmp;
        return maxTmp;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxEvents(new int[][]{
                {30, 45},
                {45, 69}
        });
        System.out.println(i);
    }
}
