package Problem_1009_十进制整数的反码;


class Solution {
    public int bitwiseComplement(int N) {
        char[] chars = Integer.toBinaryString(N).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] == '0' ? '1' : '0';
        }
        String s = new String(chars);
        int i = Integer.parseInt(s, 2);
        return i;
    }
}

class Test {

    public static void main(String[] args) {
        int i = new Solution().bitwiseComplement(5);
        System.out.println(i);
    }
}

