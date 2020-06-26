package Problem_1200_最小绝对差;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Integer minDistance = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int distance = arr[i] - arr[i - 1];
            if (distance < minDistance) list.clear();
            if (distance <= minDistance) {
                minDistance = distance;
                List<Integer> pairList = new ArrayList<>();
                pairList.add(arr[i - 1]);
                pairList.add(arr[i]);
                list.add(pairList);
            }
        }
        return list;
    }
}

class Test {
    public static void main(String[] args) {

    }
}

