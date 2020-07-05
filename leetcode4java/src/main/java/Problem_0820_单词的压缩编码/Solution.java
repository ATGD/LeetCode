package Problem_0820_单词的压缩编码;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; j--) cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }
        int ans = 0;
        for (TrieNode trieNode : nodes.keySet())
            if (trieNode.count == 0) ans += words[nodes.get(trieNode)].length() + 1;
        return ans;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;

        public TrieNode get(char c) {
            int index = c - 'a';
            if (children[index] == null) {
                children[index] = new TrieNode();
                count++;
            }
            return children[index];
        }
    }
}