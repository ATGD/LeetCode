package Problem_5364_按既定顺序创建目标数组;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) list.add(index[i], nums[i]);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] targetArray = new Solution().createTargetArray(new int[]{
                0, 1, 2, 3, 4
        }, new int[]{
                0, 1, 2, 2, 1
        });
        System.out.println(targetArray);
    }
}


