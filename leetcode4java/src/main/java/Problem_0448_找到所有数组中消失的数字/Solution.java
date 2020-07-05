package Problem_0448_找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            i++;
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                numList.add(i + 1);
            }
        }
        return numList;
    }

    private void swap(int[] nums, int indexA, int indexB) {
        nums[indexA] ^= nums[indexB];//c
        nums[indexB] ^= nums[indexA];//a
        nums[indexA] ^= nums[indexB];
    }
}

class Test {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        new Solution().findDisappearedNumbers(nums);
    }
}

