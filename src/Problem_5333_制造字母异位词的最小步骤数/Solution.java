package Problem_5333_制造字母异位词的最小步骤数;

class Solution {

    public int minSteps(String s, String t) {
        int count = 0;
        char[] sAlpha = new char[26];
        char[] tAlpha = new char[26];
        for (int i = 0; i < s.length(); i++) sAlpha[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) tAlpha[t.charAt(i) - 'a']++;
        for (int i = 0; i < sAlpha.length; i++) count += Math.abs(sAlpha[i] - tAlpha[i]);
        return count / 2;
    }
}

class Test{
    public static void main(String[] args) {
        int i = new Solution().minSteps("abcdefg", "abcdedg");
        System.out.println(i);
    }
}