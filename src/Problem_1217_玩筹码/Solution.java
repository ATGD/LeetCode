package Problem_1217_玩筹码;

class Solution {
    public int minCostToMoveChips(int[] chips) {
        int _single = 0;
        int _double = 0;
        for (int chip : chips) {
            if ((chip & 1) == 1) _single++;
            else _double++;
        }
        return Math.min(_single,_double);
    }
}
