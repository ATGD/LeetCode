package Problem_1662_检查两个字符串数组是否相等;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int index1 = 0,innerIndex1 = 0,index2 = 0,innerIndex2 = 0;

        while (index1 < word1.length && index2 < word2.length) {

            boolean flag = false;
            if (innerIndex1 >= word1[index1].length()) {
                innerIndex1 = 0;
                index1++;
                flag = true;
            }

            if (innerIndex2 >= word2[index2].length()) {
                innerIndex2 = 0;
                index2++;
                flag = true;
            }

            if (flag) continue;

            if (word1[index1].charAt(innerIndex1) != word2[index2].charAt(innerIndex2)) {
                return false;
            }

            innerIndex1++;
            innerIndex2++;
        }
        return innerIndex1 == 0 && innerIndex2 == 0 && index1 == word1.length && index2 == word2.length;
    }
}