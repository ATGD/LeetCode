package Meeting_0057_2_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> resList = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                List<Integer> itemList = new ArrayList<>();
                for (int i = l; i <= r; i++) itemList.add(i);
                resList.add(itemList);
                l++;
            } else if (sum < target) r++;
            else l++;
        }
        int[][] resAry = new int[resList.size()][];
        for (int i = 0; i < resAry.length; i++) {
            List<Integer> integers = resList.get(i);
            resAry[i] = new int[integers.size()];
            for (int j = 0; j < integers.size(); j++) {
                resAry[i][j] = integers.get(j);
            }
        }
        return resAry;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] continuousSequence = new Solution().findContinuousSequence(9);
        System.out.println(continuousSequence);
    }
}