package Problem_1202_交换字符串中的元素;

import ext.ArrayConvert;

import java.util.*;

class Solution {


    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<Set<Integer>> swapSetList = new ArrayList<>();
        for (List<Integer> pair : pairs) {
            if (pair.get(0) == pair.get(1)) continue;
            add(pair, swapSetList);
        }
        char[] chars = s.toCharArray();
        for (Set<Integer> set : swapSetList) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            int[] words = new int[26];
            for (int i = 0; i < list.size(); i++)
                words[chars[list.get(i)] - 'a']++;
            int index = 0;
            for (Integer position : list) {
                while (words[index] <= 0) index++;
                chars[position] = (char) ('a' + index);
                words[index]--;
            }
        }
        return new String(chars);
    }

    private void add(List<Integer> pair, List<Set<Integer>> swapSetList) {
        Set<Integer> contains1 = find(pair.get(0), swapSetList);
        Set<Integer> contains2 = find(pair.get(1), swapSetList);
        if (contains1 != null && contains2 != null) {
            if (contains1 != contains2)
                merge(contains1, contains2, swapSetList);
        } else if (contains1 == null && contains2 == null) {
            Set<Integer> tmpList = new HashSet<>();
            tmpList.add(pair.get(0));
            tmpList.add(pair.get(1));
            swapSetList.add(tmpList);
        } else {
            if (contains1 != null)
                contains1.add(pair.get(1));
            else
                contains2.add(pair.get(0));
        }
    }


    private Set<Integer> find(int value, List<Set<Integer>> swapSetList) {
        for (Set<Integer> pair : swapSetList) {
            if (pair.contains(value))
                return pair;
        }
        return null;
    }

    private void merge(Set<Integer> list1, Set<Integer> list2, List<Set<Integer>> swapSetList) {
        list1.addAll(list2);
        swapSetList.remove(list2);
    }
}


class Test {
    public static void main(String[] args) {
        String str = new Solution().smallestStringWithSwaps("udyyek",
                ArrayConvert.array2To(new Integer[][]{
                        {3, 3}, {3, 0}, {5, 1}, {3, 1}, {3, 4}, {3, 5}
                }));
        System.out.println(str);
    }
}

