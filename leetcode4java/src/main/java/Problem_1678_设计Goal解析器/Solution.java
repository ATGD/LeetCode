package Problem_1678_设计Goal解析器;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String interpret(String command) {

        StringBuilder sBuilder = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();

        Map<String,String> explanMap = new HashMap<>();
        explanMap.put("G", "G");
        explanMap.put("()", "o");
        explanMap.put("(al)", "al");

        int length = command.length();
        for (int i = 0; i < length; i++) {
            char c = command.charAt(i);
            switch (c) {
                case 'G':
                    resultBuilder.append(c);
                    break;
                case '(':
                case 'a':
                case 'l':
                    sBuilder.append(c);
                    break;
                case ')':
                    sBuilder.append(c);
                    resultBuilder.append(explanMap.get(sBuilder.toString()));
                    sBuilder.delete(0, sBuilder.length());
                    break;
                default:
                    break;
            }
        }
        return resultBuilder.toString();
    }
}