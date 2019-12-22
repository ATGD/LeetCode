package Problem_0241_为运算表达式设计优先级;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> resultList = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            resultList.add(Integer.parseInt(input));
            return resultList;
        }
        char[] strChars = input.toCharArray();
        for (int i = 0; i < strChars.length; i++) {
            if (strChars[i] == '+' || strChars[i] == '-' || strChars[i] == '*') {
                for (Integer left : diffWaysToCompute(input.substring(0, i))) {
                    for (Integer right : diffWaysToCompute(input.substring(i + 1, input.length()))) {
                        if (strChars[i] == '+') resultList.add(left + right);
                        else if (strChars[i] == '-') resultList.add(left - right);
                        else resultList.add(left * right);
                    }
                }
            }
        }
        return resultList;
    }
}



