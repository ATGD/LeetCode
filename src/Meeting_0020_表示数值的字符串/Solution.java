package Meeting_0020_表示数值的字符串;

class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        s = s.trim();
        //state 0 = +-
        //state 1 = 1234
        //state 2 = .
        //state 3 = 123
        //state 4 = e
        //state 5 = -
        //state 6 = 123123
        char[][] sign = new char[][]{
                {'+', '-'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'},
                {'.'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'},
                {'e', 'E'},
                {'+', '-'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'},
        };
        boolean[] stateMemo = new boolean[sign.length];
        int[] canGetAtLeast = new int[]{0, 0, 0, 0, 1, 4, 5};
        boolean[] validState = new boolean[]{false, true, true, true, false, false, true};
        boolean[] allowRepeat = new boolean[]{false, true, false, true, false, false, true};
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int assumeState = state;
            while (assumeState < sign.length) {
                boolean find = false;
                for (int j = 0; j < sign[assumeState].length; j++) {
                    if (c == sign[assumeState][j]) {
                        find = true;
                        stateMemo[assumeState] = true;
                        break;
                    }
                }
                if (find) break;
                assumeState++;
                if (assumeState == sign.length) return false;
                if (canGetAtLeast[assumeState] > state) return false;
            }
            if (assumeState == sign.length) return false;
            state = assumeState;
            if (!allowRepeat[state] && i != s.length() - 1) state++;
        }
        if (state >= validState.length) return false;
        if (state == 2) if (stateMemo[1] == false && stateMemo[3] == false) return false;
        return validState[state];
    }
}

class Test {
    public static void main(String[] args) {
        boolean isNumber = new Solution().isNumber("-5.6e-5");
        System.out.println(isNumber);
    }
}