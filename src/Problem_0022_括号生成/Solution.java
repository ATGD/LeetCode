package Problem_0022_括号生成;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> results = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recursionGeneratePar(new StringBuilder(), n, n);
        return results;
    }

    private void recursionGeneratePar(StringBuilder s, int l, int r) {
        if (l > r) return;
        if (l < 0 || r < 0) return;
        if (l == r && l == 0) {
            results.add(s.toString());
            return;
        }
        for (int i = 0; i <= l; i++) {
            int start = s.length();
            for (int j = 0; j < i; j++) {
                s.append('(');
            }
            s.append(')');
            recursionGeneratePar(s, l - i, r - 1);
            s.delete(start, start + i + 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(5);
        System.out.println(strings);
    }
}

