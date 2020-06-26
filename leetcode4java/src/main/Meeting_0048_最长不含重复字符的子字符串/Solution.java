package Meeting_0048_最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

class Solution {


    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int end = 0, start = 0; end < n; end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return ans;
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().lengthOfLongestSubstring("abba");
        System.out.println(result);
    }
}