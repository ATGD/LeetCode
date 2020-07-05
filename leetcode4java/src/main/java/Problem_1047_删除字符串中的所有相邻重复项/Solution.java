package Problem_1047_删除字符串中的所有相邻重复项;

import java.util.LinkedList;

class Solution {
    public String removeDuplicates(String S) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.size() > 0) {
                if (c == stack.peekLast()) {
                    stack.pollLast();
                    continue;
                }
            }
            stack.addLast(c);
        }
        StringBuffer sb = new StringBuffer();
        while (stack.size() > 0)
            sb.append(stack.pollFirst());
        return sb.toString();
    }
}

