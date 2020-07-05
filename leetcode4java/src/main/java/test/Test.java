package test;

import java.util.HashSet;
import java.util.Set;

class Test {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int first = 0;
        int last = 0;
        int max = 0;
        maxsize:
        while (true) {
            Set<Character> charSet = new HashSet<>();
            last = first + minSize;
            if (last >= s.length()) return max;
            String tempStr = s.substring(first, last);
            for (int i = 0; i < tempStr.length(); i++) {
                charSet.add(tempStr.charAt(i));
                if (charSet.size() > maxLetters) {
                    first++;
                    continue maxsize;
                }
            }
            int tempCount = 0;
            int findIndex = 0;
            while (findIndex < s.length()) {
                int i = s.indexOf(tempStr, findIndex);
                if (i != -1) {
                    tempCount++;
                    findIndex = i + 1;
                } else {
                    break;
                }
            }
            max = Math.max(max, tempCount);
            first++;
        }
    }
}

class Test1 {
    public static void main(String[] args) {
        int aababcaab = new Test().maxFreq("aababcaab", 2, 3, 4);
        System.out.println(aababcaab);
//        boolean possibleDivide = new Test().isPossibleDivide(new int[]{1, 2, 3, 4, 5, 6, 7, 8
//        }, 4);
//        System.out.println(possibleDivide);
    }
}

