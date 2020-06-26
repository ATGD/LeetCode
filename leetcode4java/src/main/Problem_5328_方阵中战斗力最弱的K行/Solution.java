package Problem_5328_方阵中战斗力最弱的K行;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Integer[][] arm = new Integer[mat.length][2];
        for (int i = 0; i < mat.length; i++) arm[i] = new Integer[]{countArm(mat[i]), i};
        Arrays.sort(arm, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        int[] kArray = new int[k];
        for (int i = 0; i < kArray.length; i++) kArray[i] = arm[i][1];
        return kArray;
    }

    private int countArm(int[] ints) {
        int count = 0;
        for (int anInt : ints) {
            if (anInt == 1) count++;
            else return count;
        }
        return count;
    }
}

