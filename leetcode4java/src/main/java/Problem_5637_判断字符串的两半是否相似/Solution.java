package Problem_5637_判断字符串的两半是否相似;

class Solution {
    public boolean halvesAreAlike(String s) {
        String lowerStr = s.toLowerCase();
        int[] dict1 = new int[26];
        int[] dict2 = new int[26];
        int lengthHalf = lowerStr.length() / 2;
        for (int i = 0; i < lengthHalf; i++) {
            char c = lowerStr.charAt(i);
            dict1[c - 'a']++;
        }
        for (int i = lengthHalf; i < lowerStr.length(); i++) {
            char c = lowerStr.charAt(i);
            dict2[c - 'a']++;
        }
        return (dict1['a' - 'a'] - dict2['a' - 'a'] +
                dict1['e' - 'a'] - dict2['e' - 'a'] +
                dict1['i' - 'a'] - dict2['i' - 'a'] +
                dict1['o' - 'a'] - dict2['o' - 'a'] +
                dict1['u' - 'a'] - dict2['u' - 'a']) == 0;
    }
}

class Test {
    public static void main(String[] args) {
        boolean isAlike = new Solution().halvesAreAlike("AbCdEfGh");
        System.out.println(isAlike);
    }
}