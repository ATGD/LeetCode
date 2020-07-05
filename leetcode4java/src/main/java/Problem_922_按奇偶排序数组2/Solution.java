package Problem_922_按奇偶排序数组2;

import java.util.LinkedList;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        LinkedList<Integer> singleShouldList = new LinkedList<>();
        LinkedList<Integer> doubleShouldList = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (((i ^ A[i]) & 1) == 0) continue;
            else if (((i ^ 1) & 1) == 1)/*位数为偶数，然而数字是奇数*/ {
                if (singleShouldList.size() > 0) swap(i, singleShouldList.pollFirst(), A);
                else doubleShouldList.addLast(i);
            } else /*位数是奇数，数字是偶数*/ {
                if (doubleShouldList.size() > 0) swap(i, doubleShouldList.pollFirst(), A);
                else singleShouldList.addLast(i);
            }
        }
        for (Integer i : singleShouldList) swap(i, doubleShouldList.pollFirst(), A);
        return A;
    }

    void swap(int a, int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

class Test {
    public static void main(String[] args) {
        new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7});
//        System.out.println(1 ^ 1 & 1);
    }
}
