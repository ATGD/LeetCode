package Problem_0821_字符的最短距离;

class Solution {
    public int[] shortestToChar(String S, char C) {
        int minDistance = 10000;
        int[] resultAry = new int[S.length()];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) minDistance = 0;
            resultAry[i] = minDistance++;
        }
        minDistance = 10000;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == C) minDistance = 0;
            resultAry[i] = Math.min(minDistance++, resultAry[i]);
        }
        return resultAry;
    }
}
