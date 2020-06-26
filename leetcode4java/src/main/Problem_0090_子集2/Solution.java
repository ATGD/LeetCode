package Problem_0090_子集2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) count = 0;
            count++;
            map.put(num, count);
        }
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> tmpList = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        reversionResult(results, tmpList, list, 0);
        results.add(new ArrayList<>());
        return results;
    }

    private void reversionResult(List<List<Integer>> results, ArrayList<Integer> tmpList, List<Map.Entry<Integer, Integer>> list, int index) {
        if (index >= list.size()) return;
        Map.Entry<Integer, Integer> entryItem = list.get(index);
        reversionResult(results, tmpList, list, index + 1);
        for (Integer i = 0; i < entryItem.getValue(); i++) {
            tmpList.add(entryItem.getKey());
            results.add(new ArrayList<>(tmpList));
            reversionResult(results, tmpList, list, index + 1);
        }
        for (Integer i = 0; i < entryItem.getValue(); i++)
            tmpList.remove(tmpList.size() - 1);
    }
}

class Test {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().subsetsWithDup(new int[]{1, 2, 2, 3, 3, 4});
        System.out.println(lists);
    }
}
