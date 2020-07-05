package Problem_5332_检查整数及其两倍数是否存在;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (((i & 1) != 1) && set.contains(i / 2)) return true;
            if (set.contains(i * 2)) return true;
            set.add(i);
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().checkIfExist(new int[]{
                3, 1, 7, 11
        });

        System.out.println(b);
    }
}
