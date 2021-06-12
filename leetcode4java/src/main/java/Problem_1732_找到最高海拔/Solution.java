package Problem_1732_找到最高海拔;

class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        int tmpHeight = 0;
        for (int i : gain) {
            tmpHeight += i;
            maxHeight = Math.max(maxHeight, tmpHeight);
        }
        return maxHeight;
    }
}