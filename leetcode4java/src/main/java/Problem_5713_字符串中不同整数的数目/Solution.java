package Problem_5713_字符串中不同整数的数目;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                if (sb.length()!=0) {
                    set.add(replaceFirstZero(sb));
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(aChar);
            }
        }
        if (sb.length()!=0) {
            set.add(replaceFirstZero(sb));
        }
        return set.size();
    }

    String replaceFirstZero(StringBuilder zero) {
        String s = zero.toString();
        while(s.startsWith("0")) {
            s = s.substring(1, s.length());
        }
        if (s.length() > 0) {
            return s;
        }
        return "0";
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().numDifferentIntegers("a1b01c001");
        System.out.println(result);
        System.out.println((1/2));
    }
}