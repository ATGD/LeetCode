package Gold_01_06_字符串压缩;

class Solution {
    public String compressString(String S) {
        if (null == S || S.length() == 0) return S;
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (c != chars[i]) {
                sb.append(c);
                sb.append(count);
                c = chars[i];
                count = 1;
            } else count++;
        }
        if (count != 0) {
            sb.append(c);
            sb.append(count);
        }
        if (sb.length() >= S.length()) return S;
        else return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
//        String s = new Solution().compressString("aabbccddd");
//        System.out.println(s);
        Integer a = null;
        Integer b = 1;
        if (a == null ^ b == null) {
            System.out.println("只有一个为null");
        }
    }
}
