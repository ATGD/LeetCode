package Problem_0893_特殊等价字符串组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> groups = new HashSet<>();
        int[] position = {0, 26};
        for (String s : A) {
            char[] alpha = new char[52];
            for (int i = 0; i < s.length(); i++)
                alpha[(s.charAt(i) - 'a') + position[i & 1]]++;
            groups.add(Arrays.toString(alpha));
        }
        return groups.size();
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numSpecialEquivGroups(new String[]{
                "abc", "acb", "bac", "bca", "cab", "cba"
        });
    }
}
