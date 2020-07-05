package Problem_0806_写字符串需要的行数;

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int temp = 100;
        int pages = 1;
        for (int i = 0; i < S.length(); i++) {
            int width = widths[S.charAt(i) - 'a'];
            if (temp < width) {
                pages++;
                temp = 100 - width;
            } else
                temp = temp - width;
        }
        return new int[]{pages, 100 - temp};
    }
}