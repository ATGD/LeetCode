package Problem_5772_检查某单词是否等于两单词之和;

class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = getInt(firstWord);
        int second = getInt(secondWord);
        int target = getInt(targetWord);
        return (first + second) == target;
    }

    private int getInt(String firstWord) {
        boolean isStart = false;

        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < firstWord.length(); i++) {
            int value = firstWord.charAt(i) - 'a';
            if (value == 0) {
                if (resBuilder.length() == 0 && isStart) continue;
            } else {
                isStart = true;
            }
            resBuilder.append(value);
        }
        if (resBuilder.length() == 0) return 0;
        return Integer.parseInt(resBuilder.toString());
    }
}