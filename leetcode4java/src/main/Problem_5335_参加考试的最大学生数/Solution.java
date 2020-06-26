package Problem_5335_参加考试的最大学生数;

import java.util.List;

class Solution {
    public int maxStudents(char[][] seats) {
        int n = seats.length, m = seats[0].length;
        //dp[row][state]
        Integer[][] memo = new Integer[n][1 << m];
        return dfs(seats, memo, 0, 0);
    }

    /**
     *
     * @param seats 座位详情
     * @param memo 记录
     * @param r 当前的行数
     * @param preMask 前一行的行数
     * @return
     */
    private int dfs(char[][] seats, Integer[][] memo, int r, int preMask) {
        int n = seats.length, m = seats[0].length;
        if (r == n) return 0;
        if (memo[r][preMask] != null) return memo[r][preMask];
        int res = 0;
        for (int i = 0; i < (1 << m); i++) {
            if (isValid(i, preMask, seats, r))
                res = Math.max(res, Integer.bitCount(i) + dfs(seats, memo, r + 1, i));
        }
        memo[r][preMask] = res;
        return res;
    }

    private boolean isValid(int mask, int preMask, char[][] seats, int r){
        int n = seats.length, m = seats[0].length;
        for(int i = 0 ; i < m; i++){
            if((mask & (1 << i)) == 0) continue;
            if (seats[r][i] == '#') return false;
            if(i > 0 && seats[r][i - 1] == '.' && (mask & (1 << (i - 1))) != 0) return false;
            if(i < m - 1 && seats[r][i + 1] == '.' && (mask & (1 << (i + 1))) != 0) return false;
            if(r > 0 && i > 0 && seats[r - 1][i - 1] == '.' && (preMask & (1 << (i - 1))) != 0) return false;
            if(r > 0 && i < m - 1 && seats[r - 1][i + 1] == '.' && (preMask & (1 << (i + 1))) != 0) return false;
        }
        return true;
    }
}