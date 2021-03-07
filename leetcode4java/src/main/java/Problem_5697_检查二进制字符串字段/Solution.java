package Problem_5697_检查二进制字符串字段;

class Solution {
    public boolean checkOnesSegment(String s) {
        boolean hasOne = false;
        boolean lastIsOne = false;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                if (hasOne) {
                    if (!lastIsOne) {
                        return false;
                    }
                } else {
                    hasOne = true;
                    lastIsOne = true;
                }
            } else {
                lastIsOne = false;
            }
        }
        return hasOne;
    }
}