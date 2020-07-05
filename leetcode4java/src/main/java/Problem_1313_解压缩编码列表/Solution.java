package Problem_1313_解压缩编码列表;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i +=2) {
            int times = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < times; j++) {
                returnList.add(value);
            }
        }
        int[] returnS = new int[returnList.size()];
        for (int i = 0; i < returnS.length; i++) {
            returnS[i] = returnList.get(i);
        }
        return returnS;
    }
}

class Test{
    public static void main(String[] args) {
        int[] ints = new Solution().decompressRLElist(new int[]{1, 2, 3, 4});

        System.out.println(ints);
    }
}
