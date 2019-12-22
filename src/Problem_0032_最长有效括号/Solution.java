package Problem_0032_最长有效括号;

class Solution {
    public int longestValidParentheses(String s) {
        int maxValid = 0;
        for (int i = 0; i < s.length(); i++) {
            maxValid = Math.max(maxValid, maxValidThisStr(s.substring(i)));
        }
        return maxValid;
    }

    int maxValidThisStr(String s) {
        int max = 0;
        int state = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                state++;
            } else {
                state--;
                if (state == 0) {
                    max = Math.max(max, i - start);
                } else if (state < 0) {
                    start = i + 1;
                    state = 0;
                }
            }
        }
        return max;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().longestValidParentheses("()(()))()()(())");
        System.out.println(i);
    }
}

