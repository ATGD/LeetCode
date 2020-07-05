package test.sort;

public class QuickSort {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left > right) return;
        int base = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (nums[j] >= base && i < j) j--;
            while (nums[i] <= base && i < j) i++;
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        //将基数放到中间位置（基数归位）
        nums[left] = nums[i];
        nums[i] = base;

        sort(nums, left, i - 1);
        sort(nums, j + 1, right);
    }
}
