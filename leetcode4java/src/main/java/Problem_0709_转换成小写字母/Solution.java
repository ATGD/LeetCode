package Problem_0709_转换成小写字母;


class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char mChar = chars[i];
            chars[i] = Character.toLowerCase(mChar);
//            if (mChar >= 'A' && mChar <= 'Z') chars[i] = ((char) (mChar - ('a' - 'A')));
        }
        return new String(chars);
    }
}

class Test {
    public static void main(String[] args) {

    }
}



