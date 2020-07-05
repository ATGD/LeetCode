package Problem_5413_重新排列句子中的单词;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    class Entry {
        public Entry(String str, Integer index) {
            this.str = str;
            this.index = index;
        }

        String str;
        Integer index;
    }

    public String arrangeWords(String text) {
        text = Character.toLowerCase(text.charAt(0)) + text.substring(1);
        String[] s = text.split(" ");
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(new Entry(s[i], i));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.str.length() == o2.str.length())
                return o1.index - o2.index;
            return o1.str.length() - o2.str.length();
        });
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                Entry entry = list.get(i);
                char c = entry.str.charAt(0);
                entry.str = Character.toUpperCase(c) + entry.str.substring(1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).str);
            if (i != list.size() - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String result = new Solution().arrangeWords("To be or not to be");
        System.out.println(result);
    }
}