package Meeting_0038_字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
//    public String[] permutation(String s) {
////        1,2,3,4,5,6,7,8,9
//        List<String> resultList = new ArrayList<>();
//        Set<String> containSet = new HashSet<>();
//        resultList.add(s);
//        for (int start = 0; start < s.length() - 1; start++) {
//            int size = resultList.size();
//            for (int i = start + 1; i < s.length(); i++) {
//                for (int j = 0; j < size; j++) {
//                    char[] chars = resultList.get(j).toCharArray();
//                    if (chars[start] == chars[i]) continue;
//                    char tmp = chars[start];
//                    chars[start] = chars[i];
//                    chars[i] = tmp;
//                    String item = new String(chars);
//                    if (!containSet.contains(item)) {
//                        resultList.add(item);
//                        containSet.add(item);
//                    }
//                }
//            }
//        }
//        String[] result = new String[resultList.size()];
//        resultList.toArray(result);
//        return result;
//    }

    public List<String> permutation(String s) {
        List<String> retList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        retList.add(s);
        permutation(s, retList, set, 0);
        return retList;
    }

    private void permutation(String s, List<String> retList, Set<String> set, int position) {
        if (position >= s.length() - 1)
            return;
        int size = retList.size();
        for (int i = 0; i < size; i++) {
            String tmpStr = retList.get(i);
            for (int j = position + 1; j < s.length(); j++) {
                String swap = swap(tmpStr, position, j);
                if (tmpStr.charAt(position) != tmpStr.charAt(j) && !set.contains(swap)) {
                    retList.add(swap);
                    set.add(swap);
                }
            }
        }
        permutation(s, retList, set, position + 1);
    }

    public String swap(String str, int p1, int p2) {
        char[] chars = str.toCharArray();
        char tmp = chars[p1];
        chars[p1] = chars[p2];
        chars[p2] = tmp;
        return new String(chars);
    }

}

class Test {
    public static void main(String[] args) {
        List<String> result = new Solution().permutation("kxxx");
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}