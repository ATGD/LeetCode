package test.sort;

public class HeapSort {

    public int[] sortArray(int[] nums) {

        for (int i = (nums.length >> 1) - 1; i >= 0; i--)
            adustHeap(nums, i, nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adustHeap(nums, 0, i);
        }
        return nums;
    }

    private void adustHeap(int[] nums, int i, int length) {

        int tmp = nums[i];
        for (int j = (i << 1) + 1; j < length; j = (j << 1) + 1) {
            if (j + 1 < length && nums[j + 1] > nums[j])
                j++;

            if (nums[j] > tmp) {
                nums[i] = nums[j];
                i = j;
            } else
                break;
        }
        nums[i] = tmp;
    }


    void swap(int[] nums, int i, int j) {

        if (nums[i] == nums[j]) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
