package Problem_0771_宝石与石头;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewelsMap = new HashSet<>();
        for (char c : J.toCharArray())
            jewelsMap.add(c);
        int count = 0;
        for (char c : S.toCharArray()) {
            if (jewelsMap.contains(c)) count++;
        }
        return count;
    }
}

