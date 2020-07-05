package Problem_0983_最低票价;


class Solution {

    private int lastDay = 0;
    private Integer[] memo = new Integer[400];


    public int mincostTickets(int[] days, int[] costs) {
        lastDay = days[days.length - 1];
        getMinPay(days, 0, costs);
        return memo[days[0]];
    }

    private int getMinPay(int[] days, int dayIndex, int[] costs) {
        if (dayIndex >= days.length) return 0;
        if (memo[days[dayIndex]] != null)
            return memo[days[dayIndex]];
        int min = Integer.MAX_VALUE;
        min = Math.min(min, costs[0] + getMinPay(days, dayIndex + 1, costs));
        {
            int tmpDay = dayIndex;
            while (tmpDay < days.length && days[tmpDay] < days[dayIndex] + 7) tmpDay++;
            min = Math.min(min, costs[1] + getMinPay(days, tmpDay, costs));
        }
        {
            int tmpDay = dayIndex;
            while (tmpDay < days.length && days[tmpDay] < days[dayIndex] + 30) tmpDay++;
            min = Math.min(min, costs[2] + getMinPay(days, tmpDay, costs));
        }
        memo[days[dayIndex]] = min;
        return memo[days[dayIndex]];
    }
}

class Test {
    public static void main(String[] args) {
        long i = new Solution().mincostTickets(new int[]{
                1, 4, 6, 7, 8, 20
        }, new int[]{
                7, 2, 15
        });
        System.out.println(i);
    }
}