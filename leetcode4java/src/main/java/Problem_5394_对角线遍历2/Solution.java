package Problem_5394_对角线遍历2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                count++;
                if (i + j + 1 > list.size()) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums.get(i).get(j));
                    list.add(i + j, tmpList);
                } else {
                    List<Integer> tmpList = list.get(i + j);
                    tmpList.add(0, nums.get(i).get(j));
                }
            }
        }
        int[] result = new int[count];
        int tmpIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> diagonalList = list.get(i);
            for (int j = 0; j < diagonalList.size(); j++) {
                result[tmpIndex++] = diagonalList.get(j);
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        int[] diagonalOrder = new Solution().findDiagonalOrder(list);
        System.out.println(diagonalOrder);
    }
}