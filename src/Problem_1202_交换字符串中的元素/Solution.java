package Problem_1202_交换字符串中的元素;

import ext.ArrayConvert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> swapSetList = new ArrayList<>();

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        swapSetList.clear();
        for (List<Integer> pair : pairs) {
            Integer value1 = pair.get(0);
            Integer value2 = pair.get(1);
            List<Integer> contains1 = find(value1);
            List<Integer> contains2 = find(value2);
            if (contains1 != null && contains2 != null) {
                if (contains1 != contains2)
                    merge(contains1, contains2);
            } else if (contains1 == null && contains2 == null)
                swapSetList.add(new ArrayList<>(Arrays.asList(value1, value2)));
            else {
                if (contains1 != null)
                    contains1.add(value2);
                else
                    contains2.add(value1);
            }
        }
        char[] chars = s.toCharArray();
        for (List<Integer> list : swapSetList) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) > list.get(j)) {
                        if (chars[i] < chars[j]) {
                            char temp = chars[i];
                            chars[i] = chars[j];
                            chars[j] = temp;
                        }
                    } else if (list.get(i) < list.get(j)) {
                        if (chars[i] > chars[j]) {
                            char temp = chars[i];
                            chars[i] = chars[j];
                            chars[j] = temp;
                        }
                    }
                }
            }
        }
        return new String(chars);
    }


    private List<Integer> find(int value) {
        for (List<Integer> pair : swapSetList) {
            if (pair.contains(value)) return pair;
        }
        return null;
    }

    private void merge(List<Integer> list1, List<Integer> list2) {
        list1.addAll(list2);
        swapSetList.remove(list2);
    }
}


class Test {
    public static void main(String[] args) {
        String str = new Solution().smallestStringWithSwaps("dcab",
                ArrayConvert.array2To(new Integer[][]{
                        {0, 3}, {1, 2}, {0, 2}
                }));
        System.out.println(str);
    }
}

