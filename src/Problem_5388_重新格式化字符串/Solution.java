package Problem_5388_重新格式化字符串;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public String reformat(String s) {
        List<Character> numsBuffer = new LinkedList<>();
        List<Character> alphasBuffer = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') numsBuffer.add(c);
            else alphasBuffer.add(c);
        }
        int bettweens = numsBuffer.size() - alphasBuffer.size();
        if (Math.abs(bettweens) > 1) return "";
        boolean shouldNum = bettweens >= 0;
        StringBuilder result = new StringBuilder();
        while (numsBuffer.size() > 0 || alphasBuffer.size() > 0) {
            if (shouldNum) {
                if (numsBuffer.size() == 0) return "";
                result.append(numsBuffer.remove(0));
            } else {
                if (alphasBuffer.size() == 0) return "";
                result.append(alphasBuffer.remove(0));
            }
            shouldNum = !shouldNum;
        }
        return result.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String result = new Solution().reformat("a0b1c2");
        System.out.println(result);
    }
}