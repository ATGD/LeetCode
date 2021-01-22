package Problem_5613_最富有客户的资产总量;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int tmpAcc = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                tmpAcc+=accounts[i][j];
            }
            max = Math.max(tmpAcc, max);
        }
        return max;
    }
}