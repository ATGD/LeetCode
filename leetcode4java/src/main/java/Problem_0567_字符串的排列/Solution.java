package Problem_0567_字符串的排列;


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.isEmpty()) return true;
        if (s2 == null || s2.isEmpty()) return false;
        if (s1.length() > s2.length()) return false;

        int[] dict1 = new int[26];
        int[] dict2 = new int[26];

        for (int i = 0; i < s1.length(); i++) dict1[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s1.length(); i++) dict2[s2.charAt(i) - 'a']++;

        Character oldC = null;

        for (int i = s1.length() - 1; i < s2.length(); i++) {
            if (oldC != null) {
                char newC = s2.charAt(i);
                dict2[oldC - 'a']--;
                dict2[newC - 'a']++;
            }
            oldC = s2.charAt(i - s1.length() + 1);

            boolean flag = true;
            for (int m = 0; m < dict1.length; m++) {
                if (dict1[m] != dict2[m]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().checkInclusion("abcd", "asoiejtgdacbioaserjgifoj");
        System.out.println(b);
    }
}