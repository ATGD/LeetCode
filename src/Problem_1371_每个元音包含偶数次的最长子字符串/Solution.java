package Problem_1371_每个元音包含偶数次的最长子字符串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTheLongestSubstring(String s) {
        int[] sry = new int[s.length()];
        int start = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Integer> posMap = new HashMap<>();
        map.put('a', 0b00001);
        map.put('e', 0b00010);
        map.put('i', 0b00100);
        map.put('o', 0b01000);
        map.put('u', 0b10000);
        int firstS = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start ^= (map.get(s.charAt(i)));
                if (firstS == -1) firstS = i;
            }
            sry[i] = start;
            if (posMap.containsKey(sry[i])) {
                int tmp = i - posMap.get(sry[i]);
                if (start == 0 && firstS != 0) {
                    tmp++;
                }
                if (posMap.get(sry[i]) == firstS && firstS != 0)
                    tmp = i + 1;
                max = Math.max(max, tmp);
            } else {
                posMap.put(sry[i], i);
            }
        }
        return max;
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().findTheLongestSubstring("eleetminicoworoep");
        System.out.println(result);
    }
}
