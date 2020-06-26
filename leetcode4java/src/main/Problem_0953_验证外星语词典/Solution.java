package Problem_0953_验证外星语词典;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        List<Character> alphaMap = new ArrayList<>(order.length());
        for (int i = 0; i < order.length(); i++) alphaMap.add(order.charAt(i));
        String str = words[0];
        for (int i = 1; i < words.length; i++) {
            String tmp = words[i];
            for (int j = 0; j < Math.max(str.length(), tmp.length()); j++) {
                if (j>=tmp.length()) return false;
                if (j>=str.length()) break;
                if (tmp.charAt(j) == str.charAt(j)) continue;
                int tmpIndex = alphaMap.indexOf(tmp.charAt(j));
                int strIndex = alphaMap.indexOf(str.charAt(j));
                if (tmpIndex < strIndex) return false;
                else if (tmpIndex>strIndex) break;
            }
            str = tmp;
        }
        return true;
    }
}
//
//["fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"]
//        "zkgwaverfimqxbnctdplsjyohu"

class Test{
    public static void main(String[] args) {
        boolean result = new Solution().isAlienSorted(new String[]{"fxasxpc", "dfbdrifhp", "nwzgs", "cmwqriv", "ebulyfyve", "miracx", "sxckdwzv", "dtijzluhts", "wwbmnge", "qmjwymmyox" }, "zkgwaverfimqxbnctdplsjyohu");
        System.out.println(result);
    }
}