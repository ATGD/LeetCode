package Problem_5472_重新排列字符串;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray().clone();
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            chars[index] = s.charAt(i);
        }
        return new String(chars);
    }
}

class Test {
    public static void main(String[] args) {
        String str = new Solution().restoreString("abc", new int[]{2, 1, 0});
        System.out.println(str);
    }
}