package LCP_0006_拿硬币;

class Solution {
    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count += (coin / 2 + ((coin & 1) == 1 ? 1 : 0));
        }
        return count;
    }
}