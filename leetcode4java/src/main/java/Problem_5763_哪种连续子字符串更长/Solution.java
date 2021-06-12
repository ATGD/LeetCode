package Problem_5763_哪种连续子字符串更长;

class Solution {
    public boolean checkZeroOnes(String s) {
        int zeroMax = 0;
        int oneMax = 0;
        int status = -1;
        int tmpLength = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (status < 1) {
                    tmpLength++;
                    zeroMax = Math.max(zeroMax, tmpLength);
                } else {
                    tmpLength = 1;
                    oneMax = Math.max(oneMax, tmpLength);
                }
                status = 0;
            } else {
                if (status != 0) {
                    tmpLength++;
                    oneMax = Math.max(oneMax, tmpLength);
                } else {
                    tmpLength = 1;
                    zeroMax = Math.max(zeroMax, tmpLength);
                }
                status = 1;
            }
        }
        return oneMax > zeroMax;
    }
}