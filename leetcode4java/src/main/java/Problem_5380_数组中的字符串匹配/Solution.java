package Problem_5380_数组中的字符串匹配;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        List<String> results = new ArrayList<>(words.length);
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    results.add(words[i]);
                    break;
                }
            }
        }
        return results;
    }
}

class Test {
    public static void main(String[] args) {
        List<String> result = new Solution().stringMatching(new String[]{
                "mass", "as", "hero", "superhero"
        });
        System.out.println(result);
    }
}