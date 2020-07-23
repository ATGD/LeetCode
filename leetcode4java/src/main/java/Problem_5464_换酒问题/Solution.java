package Problem_5464_换酒问题;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while (numBottles >= numExchange) {
            int ex = numBottles / numExchange;
            int last = numBottles % numExchange;
            count += ex;
            numBottles = ex + last;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numWaterBottles(15, 4);
        System.out.println(i);
    }
}