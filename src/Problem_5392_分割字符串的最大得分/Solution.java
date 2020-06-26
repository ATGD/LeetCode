package Problem_5392_分割字符串的最大得分;


class Solution {
    public int maxScore(String s) {
        int[] leftSore = new int[s.length()];
        int[] rightSore = new int[s.length()];
        char[] chars = s.toCharArray();
        int leftTmpScore = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                leftSore[i] = ++leftTmpScore;
            } else {
                leftSore[i] = leftTmpScore;
            }
        }
        int rightTmpScore = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                rightSore[i] = ++rightTmpScore;
            } else {
                rightSore[i] = rightTmpScore;
            }
        }
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < leftSore.length - 1; i++) {
            maxScore = Math.max(maxScore, leftSore[i] + rightSore[i + 1]);
        }
        return maxScore;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxScore("1111");
        System.out.println(i);
    }
}