package Problem_0032_最长有效括号;

class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != ')') continue;
            if (chars[i - 1] == '(')
                dp[i] = (i >= 2) ? dp[i - 2] + 2 : 2;
            else if (i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(')
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;

            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().longestValidParentheses("()(()))()()(())");
        System.out.println(i);
    }
}

