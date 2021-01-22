package Problem_5614_找出最具竞争力的子序列;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class Solution {
    //0,1,2,3
//    输入：nums = [3,5,2,6], k = 2
//    输出：[2,6]
    public int[] mostCompetitive(int[] nums, int k) {
        LinkedList<int[]> copyList = new LinkedList<>();
//        int[][] copys = new int[nums.length][2];
        for (int i = 0; i < copyList.size(); i++) {
            int[] copys = new int[2];
            copys[0] = nums[i];
            copys[1] = i;
            copyList.addLast(copys);
        }
        Collections.sort(copyList, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        int minIndex = 0;
        int[] result = new int[k];
//        for (int i = 0; i < result.length; ) {
//            int arrayIndex = copyList.get(0)[1];
//            if (result.length - arrayIndex + i <= k) {
//                while (i < result.length) {
//                    result[i++] = arrayIndex[arrayIndex++][0];
//                }
//                return result;
//            } else if () {
//            }
//            result[i++] = copys[copyIndex++][0];
//        }
        return result;
    }
}