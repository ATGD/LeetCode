package Problem_0556_下一个更大的元素3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int nextGreaterElement(int n) {
        String numStr = n + "";
        char[] numChars = numStr.toCharArray();
        int maxNum = Integer.MIN_VALUE;
        Map<Character, Integer> valueMap = new LinkedHashMap<>();
        for (int i = numChars.length - 1; i >= 0; i--) {
            if (numChars[i] > maxNum) {
                maxNum = numChars[i];
                valueMap.put(numChars[i], i);
            } else if (numChars[i] == maxNum) {
            } else {
                Iterator<Map.Entry<Character, Integer>> iterator = valueMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Character, Integer> next = iterator.next();
                    Character key = next.getKey();
                    Integer value = next.getValue();
                    if (key > numChars[i]) {
                        char temp = 0;
                        temp = numChars[i];
                        numChars[i] = numChars[value];
                        numChars[value] = temp;
                        char[] chars = new char[numChars.length - i - 1];
                        System.arraycopy(numChars, i + 1, chars, 0, chars.length);
                        Arrays.sort(chars);
                        System.arraycopy(chars, 0, numChars, i + 1, chars.length);
                        try {
                            return Integer.parseInt(new String(numChars));
                        } catch (NumberFormatException e) {
                            return -1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

class Test {

    public static void main(String[] args) {
        int i = new Solution().nextGreaterElement(3654321);
        System.out.println(i);
        //3654321
        //4335621
    }
}

