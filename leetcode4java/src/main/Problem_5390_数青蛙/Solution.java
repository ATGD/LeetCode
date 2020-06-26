package Problem_5390_数青蛙;

import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Character, Integer> map = new HashMap<>();

    {
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] alpha = new int[5];
        int max = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            int index = map.get(c);
            alpha[index]++;
            for (int j = 0; j < index; j++) if (alpha[j] < alpha[j + 1]) return -1;
            if (c == 'k') {
                for (int m = 0; m < alpha.length; m++) max = Math.max(max, alpha[m]);
                for (int k = 0; k < alpha.length; k++) alpha[k]--;
            }
        }
        for (int value : alpha) if (value!=0) return -1;
        return max;
    }
}

class Test {
    public static void main(String[] args) {
        int croakcroak = new Solution().minNumberOfFrogs("croakcroak");
        System.out.println(croakcroak);
    }
}