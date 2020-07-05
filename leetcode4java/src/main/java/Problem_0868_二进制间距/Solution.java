package Problem_0868_二进制间距;

class Solution {
    public int binaryGap(int N) {
        int lastNo1 = -1;
        int maxDistance = 0;
        int position = 0;
        while (N > 0) {
            int value = N % 2;
            if (lastNo1 == -1) {
                if (value == 1) {
                    lastNo1 = position;
                }
            } else {
                if (value == 1) {
                    maxDistance = Math.max(maxDistance, position - lastNo1);
                    lastNo1 = position;
                }
            }
            position++;
            N /= 2;
        }
        return maxDistance;
    }
}
