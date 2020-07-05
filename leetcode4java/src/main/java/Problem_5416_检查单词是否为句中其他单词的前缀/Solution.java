package Problem_5416_检查单词是否为句中其他单词的前缀;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] sentences = sentence.split(" ");
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].startsWith(searchWord)) return i + 1;
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Solution().isPrefixOfWord("hello from the other side", "they");
        System.out.println(result);
    }
}