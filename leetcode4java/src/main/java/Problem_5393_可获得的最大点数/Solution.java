package Problem_5393_可获得的最大点数;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            total += cardPoints[i];
        }
        if (k == cardPoints.length) return total;
        int tmpValue = 0;
        for (int i = 0; i <= cardPoints.length - k - 1; i++) {
            tmpValue += cardPoints[i];
        }
        int min = tmpValue;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            tmpValue -= cardPoints[i - (cardPoints.length - k)];
            tmpValue += cardPoints[i];
            min = Math.min(min, tmpValue);
        }
        return total - min;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxScore(new int[]{
                1, 4, 2, 1001, 6, 2, 1
        }, 3);
        System.out.println(i);
    }
}