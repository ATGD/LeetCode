package Problem_1021_删除最外层的括号;

class Solution {
    public String removeOuterParentheses(String S) {
        StringBuffer sb = new StringBuffer();
        int state = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                state++;
                if (state > 1) sb.append(c);
            } else {
                state--;
                if (state >= 1) sb.append(c);
            }
        }
        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        new Solution().removeOuterParentheses("(()())()()");
    }
}

