package Problem_1684_统计一致字符串的数目;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] alpa = new boolean[26];
        for (int i = 0; i < allowed.length(); i++)
            alpa[allowed.charAt(i) - 'a'] = true;

        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!alpa[word.charAt(i) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }
}