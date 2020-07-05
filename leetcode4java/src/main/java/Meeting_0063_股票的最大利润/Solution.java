package Meeting_0063_股票的最大利润;

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0, profit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price > min) {
                profit = Math.max(profit, price - min);
            }
//            if (price < min) {
//                min = price;
//                max = 0;
//            } else if (price >= max) profit = Math.max(profit,(max = price) - min);
        }
        return profit;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(i);
    }
}