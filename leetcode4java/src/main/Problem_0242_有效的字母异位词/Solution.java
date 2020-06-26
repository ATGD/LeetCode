package Problem_0242_有效的字母异位词;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] sAlpha = new int[26];
        int[] tAlpha = new int[26];
        for (char c : sChar) sAlpha[c - 'a']++;
        for (char c : tChar) tAlpha[c - 'a']++;
        for (int i = 0; i < sAlpha.length; i++) {
            if (sAlpha[i] != tAlpha[i]) return false;
        }
        return true;
    }
}

class Test{
    public static void main(String[] args) {
        boolean anagram = new Solution().isAnagram("abc", "bcad");
        System.out.println(anagram);
    }
}
