package Problem_1189_气球的最大数量;

class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] alpha = new char[26];
        for (int i = 0; i < text.length(); i++)
            alpha[text.charAt(i) - 'a']++;
        String wordStr = "ballon";
        char[] words = new char[26];
        for (int i = 0; i < wordStr.length(); i++)
            words[wordStr.charAt(i) - 'a']++;
        int times = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == 0) continue;
            int b = alpha[i] / words[i];
            if (b == 0)
                return 0;
            times = Math.min(times, b);
        }
        return times;
    }
}
