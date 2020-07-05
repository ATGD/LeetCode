package test;

import java.util.ArrayList;
import java.util.List;

public class WordTreeTest {


    public WordTreeTest(String[] testWord) {
        WordTree wordTree = createWordTree(testWord);
        System.out.println(wordTree);
    }

    private WordTree createWordTree(String[] testWord) {
        WordTree wordTree = new WordTree(null);
        for (String s : testWord) {
            WordTree tmp = wordTree;
            for (int i = 0; i < s.length(); i++) {
                tmp = tmp.add(s.charAt(i));
            }
            tmp.add(null);
        }
        return wordTree;
    }

    public static void main(String[] args) {
        String[] testWord = {
                "京张", "京张高铁", "京张高铁北京北站", "宣传", "宣传活动", "活动展台", "在", "今天", "在今天", "今天的", "的", "宣布", "了", "开通", "正式开通", "上", "，", "。"
        };
        String word = "在今天的宣传活动展台上，宣布了京张高铁北京北站开通。";
        WordTreeTest wordTreeTest = new WordTreeTest(testWord);

    }


    class WordTree {
        Character _char = null;
        List<WordTree> child = new ArrayList<>();

        public WordTree(Character _char) {
            this._char = _char;
        }

        WordTree add(Character s) {
            for (WordTree wordTree : child) {
                if (wordTree._char == null && s == null) return wordTree;
                if (wordTree._char == null ^ s == null) continue;
                if (wordTree._char.charValue() == s.charValue())
                    return wordTree;
            }
            WordTree wordTree = new WordTree(s);
            child.add(wordTree);
            return wordTree;
        }
    }
}
