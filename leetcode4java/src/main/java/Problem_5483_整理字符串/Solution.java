package Problem_5483_整理字符串;

import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
            } else {
                Character peekChar = stack.peek();
                if (Math.abs(peekChar - s.charAt(i)) == 32) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            strBuilder.insert(0, pop);
        }
        return strBuilder.toString();
    }
}


class Test {
    public static void main(String[] args) {
        String result = new Solution().makeGood("leEeetcode");
        System.out.println(result);
    }
}