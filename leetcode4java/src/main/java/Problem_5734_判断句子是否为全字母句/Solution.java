package Problem_5734_判断句子是否为全字母句;

class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] alpha = new boolean[26];
        for (int i = 0; i < sentence.length(); i++)
            alpha[sentence.charAt(i) - 'a'] = true;

        for (boolean b : alpha) {
            if (!b) return false;
        }
        return true;
    }
}