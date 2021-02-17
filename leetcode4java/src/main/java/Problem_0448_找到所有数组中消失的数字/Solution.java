package Problem_0448_找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while ((nums[i] != i + 1) && (nums[i] != nums[nums[i] - 1]))
                swap(nums, i, nums[i] - 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1) list.add(i + 1);
        return list;
    }

    private void swap(int[] nums, int indexA, int indexB) {
        int C = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = C;
    }
}

class Test {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = new Solution().findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }
}

