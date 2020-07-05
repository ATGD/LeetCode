package Problem_5315_6和9组成的最大数字;

class Solution {
    public int maximum69Number (int num) {
        String s = num + "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
