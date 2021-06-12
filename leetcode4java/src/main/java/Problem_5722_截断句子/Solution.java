package Problem_5722_截断句子;


class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            builder.append(words[i] + " ");
        }
        builder.append(words[k - 1]);
        return builder.toString();
    }
}