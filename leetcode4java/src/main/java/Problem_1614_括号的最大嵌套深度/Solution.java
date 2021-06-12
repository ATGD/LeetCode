package Problem_1614_括号的最大嵌套深度;

class Solution {
    public int maxDepth(String s) {
        int maxDeep = 0;
        int tmpDeep = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    tmpDeep++;
                    maxDeep = Math.max(maxDeep, tmpDeep);
                    break;
                case ')':
                    tmpDeep--;
                    break;
                default:
                    break;
            }
        }
        return maxDeep;
    }
}