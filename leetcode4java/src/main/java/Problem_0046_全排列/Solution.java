package Problem_0046_全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> prepareList = new ArrayList<>();
        for (int num : nums)
            prepareList.add(num);
        resultList.add(prepareList);
        swapAndAdd(nums.length, 0, resultList);
        return resultList;
    }

    private void swapAndAdd(int length, int start, List<List<Integer>> resultList) {
        if (start >= length) return;
        int size = resultList.size();
        for (int i = 0; i < size; i++) {
            for (int j = start + 1; j < length; j++) {
                ArrayList<Integer> integers = new ArrayList<>(resultList.get(i));
                Collections.swap(integers, start, j);
                resultList.add(integers);
            }
        }
        swapAndAdd(length, start + 1, resultList);
    }
}

class Test {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution().permute(new int[]{1, 2, 3,4});
        System.out.println(permute);
    }
}
