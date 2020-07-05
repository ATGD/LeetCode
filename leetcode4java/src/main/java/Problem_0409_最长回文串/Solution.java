package Problem_0409_最长回文串;

class Solution {
    public int longestPalindrome(String s) {
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++)
            letters[s.charAt(i)]++;
        int count = 0;
        for (int letter : letters) {
            count += letter / 2 * 2;
            if (count % 2 == 0 && letter % 2 == 1)
                count++;
        }
        return count;
    }

}
