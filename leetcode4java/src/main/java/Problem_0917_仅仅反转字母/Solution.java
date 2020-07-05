package Problem_0917_仅仅反转字母;

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            while (!Character.isLetter(chars[start])) {
                if (++start >= end)
                    return new String(chars);
            }
            while (!Character.isLetter(chars[end])) {
                if (start >= --end)
                    return new String(chars);
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().reverseOnlyLetters("7_28]");
        System.out.println(s);
    }
}

